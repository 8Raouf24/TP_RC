import sys,time
import re,os
import subprocess
f=open(sys.argv[1],"r")
f2=open('tst.cnf',"w")
x=f.readlines()
y=re.search("(.) (...) (\d*) (\d*)",x[0])
f2.write(y.group(1)+" "+y.group(2)+" "+y.group(3)+" "+str(int(y.group(4))+len(sys.argv)-2)+"\n")
for i in range(1,len(x)):
    f2.write(x[i])

for i in range(2,len(sys.argv)):
    f2.write("\n"+sys.argv[i]+" 0")
f2.close()
f.close()
cmd="ubcsat.exe -alg saps -i tst.cnf -solve"
os.system(cmd)



