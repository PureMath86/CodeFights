def newRoadSystem(roadRegister):
#    print zip(*roadRegister)
    for m in range(len(roadRegister)):
        if sum(roadRegister[m]) != sum (zip(*roadRegister)[m]): return False
    return True
