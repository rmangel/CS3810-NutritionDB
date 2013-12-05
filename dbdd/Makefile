SOURCE=$(wildcard *.tex)
OBJ=$(SOURCE:%.tex=%.pdf)

view: SOURCELISTING compile
	gnome-open $(OBJ)

compile: $(OBJ)

%.pdf : %.tex
	pdflatex -draftmode -interaction=nonstopmode -halt-on-error $<
	pdflatex -interaction=nonstopmode -halt-on-error $<

SOURCELISTING:
	ln -fs ../java prj.link
	mkdir -p gen
	./get-source-listing.sh > gen/java-source-listing.tex
clean:
	rm -f *.aux *.log *.pdf *.toc *.backup
	rm -f prj.link
	rm -rf gen
