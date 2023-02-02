from flask import Flask

app = Flask(__name__)

@app.route("/")

def helloWorldFunction():
    return("<p>hello world</p>")

@app.route("/test")
def helloTest():
    return ("<h1>hallo test</h1>")