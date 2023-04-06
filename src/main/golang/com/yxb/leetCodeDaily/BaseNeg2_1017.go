package leetCodeDaily

import "math"

func baseNeg2(n int) string {
	if n == 0 {
		return "0"
	}
	i := 0
	product := []int{1}
	for ; product[i] < n; i++ {
		product = append(product, product[i]*-2)
	}
	_, s := dfs(product, 0, i, n, "")
	return s
}

func dfs(product []int, currentSum, index, n int, currentString string) (bool, string) {
	if currentSum == n {
		for ; index >= 0; index-- {
			currentString += "0"
		}
		return true, currentString
	}
	if index < 0 {
		return false, ""
	}
	differ := math.Abs(float64(currentSum - n))
	if differ > math.Abs(float64(product[index]))*2 {
		return false, ""
	}
	if currentString == "0" {
		currentString = ""
	}
	success, resultString := dfs(product, currentSum+product[index], index-1, n, currentString+"1")
	if success {
		return success, resultString
	}
	if currentString == "0" {
		currentString = ""
	}
	success, resultString = dfs(product, currentSum, index-1, n, currentString+"0")
	return success, resultString
}
