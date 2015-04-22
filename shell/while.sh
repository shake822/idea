#!/bin/bash
i=0
while [ $i -le 10 ]
do
 i=`expr $i + 1`
 if [ `expr $i % 2` == 0 ] ;then
  continue
 fi
 echo $i
done
