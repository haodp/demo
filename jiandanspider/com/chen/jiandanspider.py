import os
import requests
from bs4 import BeautifulSoup
from com.chen.downloader import *

path = "D:\\images_dir\\"

homepage_url = "http://jandan.net/ooxx"
homepage_response = requests.get(homepage_url, timeout=5)
homepage_html = BeautifulSoup(homepage_response.text, "html.parser")
current_elements = homepage_html.select(".current-comment-page")
current_page = eval(current_elements[0].text[1:5]) + 1

prefix_url = "http://jandan.net/ooxx/page-"
page_num = eval(input("请输入下载页数:"))
suffix_url = "#comments"
if not os.path.exists(path):
    os.makedirs(path)

for page in range(page_num):
    current_page -= 1
    request_url = '%s%s%s' % (prefix_url, current_page, suffix_url)
    try:
        response = requests.get(request_url, timeout=5)
    except:
        print("..........网络异常，正在重新连接..........")
        continue
    response.encoding = 'utf-8'
    html = BeautifulSoup(response.text, "html.parser")
    images = html.select(".view_img_link")
    for item in images:
        img_url = item["href"]
        try:
            downloader = Downloader()
            downloader.download_image(img_url, path)
        except:
            print("..........网络异常，正在重新连接..........")
            continue
print("下载结束，保存路径为: " + path)
print("-------------------------------------------")
print("作者辛海臣，QQ：953899919")
input("----------------按回车鍵退出----------------")
