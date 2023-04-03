package leetCodeDaidy

func prevPermOpt1(arr []int) []int {
	beginIndex := -1
	i := len(arr) - 2
	for ; i >= 0; i-- {
		if arr[i] > arr[i+1] {
			beginIndex = i
			break
		}
	}
	if beginIndex < 0 {
		return arr
	}
	biggestIndex := -1
	biggest := -1
	for ; i < len(arr); i++ {
		if arr[i] > biggest && arr[i] < arr[beginIndex] {
			biggestIndex = i
			biggest = arr[i]
		}
	}
	if biggestIndex != -1 {
		arr[beginIndex], arr[biggestIndex] = arr[biggestIndex], arr[beginIndex]
	}
	return arr
}
