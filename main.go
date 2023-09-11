package main

import "C"

import (
	"github.com/TBD54566975/ssi-sdk/crypto"
	"github.com/TBD54566975/ssi-sdk/did/key"
	"github.com/TBD54566975/ssi-sdk/example"
	"github.com/TBD54566975/ssi-sdk/util"
)

//export GenerateDidDoc
func GenerateDidDoc() *C.char {
	_, didKey, err := key.GenerateDIDKey(crypto.Ed25519)
	if err != nil {
		example.HandleExampleError(err, "failed to generate key")
	}

	didDoc, err := didKey.Expand()
	if err != nil {
		example.HandleExampleError(err, "failed to expand did:key")
	}

	if dat, err := util.PrettyJSON(didDoc); err != nil {
		example.HandleExampleError(err, "failed to marshal did document")
	} else {
		return C.CString(string(dat))
	}
	return C.CString("")
}

func main() {}
