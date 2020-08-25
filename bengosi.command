#!/bin/bash

MY_DIRNAME=$(dirname $0)
cd $MY_DIRNAME
cd src

java Bengosi

cd ../beforeFile
mv * ../afterFile

exit 0