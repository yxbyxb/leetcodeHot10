package main

import (
	"fmt"
)

func main() {
	f1 := test()
	f2 := test()
	fmt.Println(f1)
	fmt.Println(f2)
	f1()
	f1()
	f2()
	f2()
}

func test() func() {
	i := 1
	return func() {
		i++
		fmt.Println(i)
	}
}

func testIota() {
	const (
		a = iota
		b
		c = 100
		d
		e
	)
	fmt.Println(a, b, c, d, e)
}
