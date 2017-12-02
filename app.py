from flask import Flask, render_template, abort
import os, json

app = Flask(__name__)
app.config['TEMPLATES_AUTO_RELOAD'] = True #不知道为什么在我这里不管用

@app.route('/')
def index():
    os.chdir('/home/shiyanlou/files')
    with open('helloshiyanlou.json') as f1:
        a = json.loads(f1.read())
    with open('helloworld.json') as f2:
        b = json.loads(f2.read())
    list1 = [a['title'], b['title']]
    return render_template('index.html', a=a, b=b, list1=list1)
    
@app.route('files/<filename>')
def file(filename):
    os.chdir('/home/shiyanlou/files')
    filename += '.json'
    if os.path.exists(filename):
        with open(filename) as f1:
            a = json.loads(f1.read())
        return render_template('file.html', a=a)
    else:
        abort(404)
       
@app.errorhandler(404)
def not_found(error):
    return render_template('404.html')
