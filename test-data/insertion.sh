while [ $# -gt 0 ]; do
    FILE="$1"
    shift

    while read LINE; do
        FIELDS=""
        while read FIELD; do
            FCHAR=${FIELD:0:1}
            if [[ $FCHAR > '9' ]]; then
                FIELDS="$FIELDS'$FIELD', "
            else
                FIELDS="$FIELDS$FIELD, "
            fi
        done < <(
            echo "$LINE" | \
                xargs -d "," -i echo "{}"| head -n-1
        )
        FIELDS="${FIELDS:0:${#FIELDS}-2}"
        echo "INSERT INTO ${FILE%%.csv} VALUES ( $FIELDS );"
    done < <( tail -n+2 "$FILE" | sed "s/\r//g;s/\t//g" )
done
