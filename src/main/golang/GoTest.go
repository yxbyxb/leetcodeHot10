package main

import (
	"./com/yxb/leetCodeDaily"
	"fmt"
)

type ListNode = leetCodeDaily.ListNode

func main() {

	head := &ListNode{Val: 5}
	temp := &ListNode{Val: 1, Next: head}
	head = temp
	temp = &ListNode{Val: 2, Next: head}
	head = temp
	nodes := nextLargerNodes(head)
	fmt.Println(nodes)
}

func nextLargerNodes(head *ListNode) []int {
	temp := head
	var list []int
	result := []int{0}
	for temp != nil {
		list = append(list, temp.Val)
		temp = temp.Next
	}
	resultList := &ListNode{Val: list[len(list)-1]}
	for i := len(list) - 2; i >= 0; i-- {
		if list[i] < list[i+1] {
			tempResult := &ListNode{Val: list[i], Next: resultList}
			resultList = tempResult
			// result = append([]int{list[i+1]}, result...)
			result = append(result, list[i+1])
		} else {
			nextBig := getNextBig(resultList.Next, list[i])
			tempVal := 0
			if nextBig != nil {
				tempVal = nextBig.Val
			}
			tempResult := &ListNode{Val: list[i], Next: nextBig}
			resultList = tempResult
			// result = append([]int{tempVal}, result...)
			result = append(result, tempVal)
		}
	}
	Reverse(&result, len(result))
	return result
}

func getNextBig(head *ListNode, temp int) *ListNode {
	for head != nil {
		if head.Val > temp {
			return head
		}
		head = head.Next
	}
	return nil
}

// Reverse 数组倒序函数
func Reverse(arr *[]int, length int) {
	var temp int
	for i := 0; i < length/2; i++ {
		temp = (*arr)[i]
		(*arr)[i] = (*arr)[length-1-i]
		(*arr)[length-1-i] = temp
	}
}
