
from flask import Flask, render_template, abort
import os
import json

app = Flask(__name__)

class Files(object):
    def get_title_list(self):
        # list of all files under this path
        # ['helloshiyanlou.json', 'helloworld.json']
        list1 = os.listdir('/home/shiyanlou/files/')
        return [x[:-5] for x in list1]
    
    def get_dict_by_filename(self, filename):
        filename = '/home/shiyanlou/files' + filename + '.json'
        with open(filename) as f1:
            if not os.path.exists(filename):
                abort(404)
            dict1 = json.loads(f1.read())
            return dict1
            
files = Files()

@app.route('/')
def index():
    list1 = files.get_title_list()
    return render_template('index.html', list1=list1)
    
@app.route('/files/<filename>')
def file(filename):
    dict1 = files.get_dict_by_filename(filename)
    return render_template('file.html', dict1=dict1)
    
@app.errorhandler(404)
def not_found(error):
    return render_template('404.html')

