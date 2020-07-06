JAVA = src/main/java/

clean:
	@-rm -rf $(JAVA)/todo_transport/v1/

generate: clean
	frugal -out $(JAVA) --gen=java:generated_annotations=undated todo.frugal