//https://github.com/Microsoft/TypeScript/wiki/Using-the-Compiler-API
function transpile(fileNames, options) {

	result = ts.transpile(fileNames, options);
	return  { output: result};

}
