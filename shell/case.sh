#!/bin/bash
echo -n "yes or no? "
read op
case $op in 
 yes|Y) echo -n "yes";;
 no|N) echo -n "no"
esac
