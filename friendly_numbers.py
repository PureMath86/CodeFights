def friendly_numbers(x, y):
    p = a = b = 0
    while p<x+y:
        p += 1
        if x%p<1:
            a += p
        if y%p<1:
            b += p
    return "YNeos"[a!=b or x==y::2]
