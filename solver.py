from pysat.solvers import  Solver
from pysat.examples.genhard import CNF
import sys
n=len(sys.argv)

s = Solver(name='g3')

bc=CNF(from_file=sys.argv[1])
a=True
for i in bc:

    s.add_clause(i)
for i in range(2,n):
    x=[]
    x.append(-int(sys.argv[i]))
    if s.solve(assumptions=x):
        print("insatisfiable ")
        a=False
        break
    else:
        pass
if a :
    print("BC infère ,")

