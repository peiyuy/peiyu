import scrapy

class GithubSpider(scrapy.Spider):
    name = 'github'
    
    def start_requests(self):
        url_tmpl = 'https://github.com/shiyanlou?page={}&tab=repositories'
        urls = (url_tmpl.format(i) for i in range(1, 5))
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)
    
    def parse(self, response):
        for x in response.css('li.col-12'):
            yield {
                'name': x.css('h3 a::text').re_first('\n        (.+)'),
                'update_time': x.css('relative-time::attr(datetime)').extract_first()
                }
