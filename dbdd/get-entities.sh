#!/bin/bash
echo \\begin{enumerate}
grep CREATE ../ddl/Tables.sql | sed "s|CREATE TABLE ||g;s| .*||g;s|\(.*\)|\\\\item \1|g"
echo \\end{enumerate}
