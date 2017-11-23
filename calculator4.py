from multiprocessing import Process, Queue
import sys

filename1 = sys.argv[4]
filename2 = sys.argv[2]
filename3 = sys.argv[6]

queue1 = Queue()
queue2 = Queue()

def func1(x):
    data = x.split(',')
    queue1.put(data)
    
def func2():
    with open(filename2) as f2:
        data = queue1.get()
        n,salary = data
        salary = int(salary)
        list2 = f2.readlines()
        ratio = 0
        for y in list2:
            _,_,r = y.split()
            r = float(r)
            if r > 1 and r < 3000:
                JiShuL = r
            elif r > 15000:
                JiShuH = r
            else:
                ratio += r
        if salary < JiShuL:
            a = JiShuL * ratio
        elif salary > JiShuH:
            a = JiShuH * ratio
        else:
            a = salary * ratio
        b = salary - a - 3500
        if b < 0:
            c = 0
        elif b > 0 and b <= 1500:
            c = b * 0.03 - 0
        elif b > 1500 and b <= 4500:
            c = b * 0.1 - 105
        elif b > 4500 and b <= 9000:
            c = b * 0.2 - 555
        elif b > 9000 and b <= 35000:
            c = b * 0.25 - 1005
        elif b > 35000 and b <= 55000:
            c = b * 0.3 - 2755
        elif b > 55000 and b <= 80000:
            c = b * 0.35 - 5505
        else:
            c = b * 0.45 - 13505
        newdata = [n, salary, a, c, salary-a-c]
        queue2.put(newdata)
        
def func3():
    newdata = queue2.get()
    with open(filename3, 'a') as f3:
        n,salary,a,c,get = newdata
        f3.write("{},{},{:.2f},{:.2f},{:.2f}".format(n,salary,a,c,get))
        f3.write('\n')
    
def main():
    with open(filename1) as f1:
        list1 = f1.readlines()
        for x in list1:
            Process(target=func1, args=(x,)).start()
            Process(target=func2).start()
            Process(target=func3).start()
            
if __name__ == '__main__':
    main()
