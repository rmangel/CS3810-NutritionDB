#!/bin/bash
while [ $# -gt 0 ]; do
    FILE=$1
    shift
    
    COMMAND=""
    KEYWORDS=("TABLE")
    KEYWORDS+=("SEQUENCE")
    for KEYWORD in "${KEYWORDS[@]}"; do
        COMMAND="${COMMAND}s/CREATE $KEYWORD \([[:alnum:]]*\)/DROP $KEYWORD \1\;\nCREATE $KEYWORD \1/g;"
    done
    
    
    COMMAND="${COMMAND}s/UNKNOWN/VARCHAR(20)/g;"
    cat <(
        grep "FOREIGN KEY" Tables.sql | \
        sed "s/FOREIGN KEY.*$/;/g;s/ADD CONSTRAINT/DROP CONSTRAINT/g;"
    ) <(
        cat Tables.sql | sed "$COMMAND"
    )
done