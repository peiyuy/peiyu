#!/usr/bin/env python3

import sys

try:
    if len(sys.argv) == 1:
        raise IndexError()
    list1 = sys.argv[1::]
    for x in list1:
        n, salary = x.split(':')
        if not salary.isdigit():
            raise ValueError()
        salary = int(salary)
        a = 0.165 * salary
        b = salary - a - 3500
        global c
        if b <= 1500:
            c = b * 0.03 - 0
        elif b > 1500 and b <= 4500:
            c = b * 0.1 - 105
        elif b > 4500 and b <= 9000:
            c = b * 0.2 - 555
        elif b > 9000 and b <= 35000:
            c = b * 0.25 -1005
        elif b > 35000 and b <= 55000:
            c = b * 0.3 - 2755
        elif b > 55000 and b <= 80000:
            c = b * 0.35 - 5505
        else:
            c = b * 0.45 - 13505
        if b < 0:
            get = salary - a
            print(n + ':' + "{:.2f}".format(get))
        else:
            get = salary - a - c
            print(n + ':' + '"{:.2f}".format(get))
except ValueError:
    print("Parameter Error")
except IndexError:
    print("Parameter Error")
            
    
