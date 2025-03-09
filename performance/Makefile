TESTS=$(sort $(basename $(wildcard *.lama)))

LAMAC=lamac
LAMAT=../lama -J-Xss8m --disable-launcher-output

.PHONY: check $(TESTS)

check: $(TESTS)

$(TESTS): %: %.lama
	@echo $@
# 	$(LAMAC) $<
	@cat Sort.input | LAMA=../runtime `which time` -f "$@ (-i) \t%U" $(LAMAC) -i $<
	@cat Sort.input | LAMA=../runtime `which time` -f "$@ (-s) \t%U" $(LAMAC) -s $<
	@cat Sort.input | LAMA=../runtime `which time` -f "$@ compiled \t%U" ./$@
	@cat Sort.input | `which time` -f "$@ truffle \t%U" $(LAMAT) $<

clean:
	$(RM) test*.log *.s *~ $(TESTS) *.i *.bc
