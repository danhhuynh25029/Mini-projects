import csv
import json
import xml
import glob
import os
class ETL:
    def __init__(self,path):
        self.path = path
        self.data = []
    def extract(self):
        for i in glob.glob(self.path+"*.*"):
            s = i.split(".")
            if s[len(s) -1 ] == "json":
                f = open(i,"r")
                j = json.load(f)
                for item in j:
                    self.data.append([item["Name"],str(item["Age"]),item["City"]])
                # print(self.data)
            elif s[len(s) -1 ] == "csv":
                f = open(i,"r+")
                c = csv.reader(f)
                for item in c:
                    tmp = []
                    for ic in item[0].split(";"):
                        tmp.append(ic)
                    self.data.append(tmp)
            elif s[len(s) -1 ] == "xml":
                pass
    def transform(self):
        for i in self.data:
            i[1] = int(i[1])
    def load(self,name):
        # save data to file csv
        with open(f"./result/{name}.csv","a+") as f:
            write = csv.writer(f)
            write.writerows(self.data)
    def logging(self):
        pass
if __name__ == "__main__":
    e = ETL("./data/")
    e.extract()
    e.transform()
    e.load("data_final")

