echo "$0"
#param=sss
if [ -f "/home/zhaoqunqi/test" ] ;then
 echo "is file"    
elif [ -n "$param" ];then
 echo "has value $param"
else
 echo "no value"
fi
if [ -s "/Users/zhaoqunqi/opensource/git/idea/shell/empty1" ] ; then
  echo "is empty"
else
  echo "not empty"
fi
exit 0
