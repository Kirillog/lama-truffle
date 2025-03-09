TESTS=$(sort $(basename $(wildcard test*.lama)))


.PHONY: check $(TESTS)

check: $(TESTS)

$(TESTS): %: %.lama
	@echo "regression/$@"
	@cat $@.input | ../standalone/target/lamanative --disable-launcher-output $< > $@.log && diff $@.log orig/$@.log
clean:
	$(RM) test*.log *~ $(TESTS)
