

这里最难的地方在于怎么把String'2017-12-11T10:35:57Z'
convert into datetime.datetime(2017, 12, 11, 10, 35, 57)

在python shell中演示一遍
>>>a = '2017-12-11T10:35:57Z'
# removes T and Z from String
>>>b = a[:10] + a[11:-1]
>>b
'2017-12-1110:35:57'
>>>datetime.strptime(b, '%Y-%m-%d%H:%M:%S')
datetime.datime(2017, 12, 11, 10, 35, 57)

pipelines.py
from sqlalchemy.orm import sessionmaker
from shiyanlou.models import Repository, engine
from datetime import datetime

class ShiyanlouPipeline(object):
    def process_item(self, item, spider):
        a = item['update_time']
        b = a[:10] + a[11:-1]
        item['update_time'] = datetime.strptime(b, '%Y-%m-%d%H:%M:%S')
        self.session.add(Repository(**item))
        return item
        
    def open_spider(self, spider):
        Session = sessionmaker(bind=engine)
        self.session = Session()
        
    def close_spider(self, spider):
        self.session.commit()
        self.session.close()
        
        
spiders/repositories.py
import scrapy
from shiyanlou.items import RepositoryItem

class RepositoriesSpiders(scrapy.Spider):
    name = 'repositories'
    
    @property
    def start_urls(self):
        url_tmpl = 'https://github.com/shiyanlou?page={}&tab=repositories'
        return (url_tmpl.format(i) for i in range(1, 5))
        
    def parse(self, response):
        for x in response.css('li-col-12'):
            yield RepositoryItem({
                'name': x.css('h3 a::text').re_first('\n        (.+)'),
                'update_time': x.css(relative-time::attr(datetime)').extract_first()
            })
                
