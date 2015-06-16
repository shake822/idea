#!/bin/bash
var=http://m.www.aaa.com/123.html
echo $var
echo ${var#*m}
echo ${var##*m}
echo "#\## 删除左边保留右边。#从左侧开始找，##从右侧开始找 *m"
echo ${var%m*}
echo ${var%%m*}
echo "%\%% 删除右边保留左边。%从右侧开始找，%%从左侧开始找 m*"
echo ${var:0:5}
echo ${var:7}
echo ${var:0-7:3}
echo ${var:7-0:3}
