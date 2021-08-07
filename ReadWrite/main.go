package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
)

func readFile() ([]string, bool) {

	var lines []string
	file, err := os.Open("numbers.txt")
	if err != nil {
		log.Fatalf("Failed to open")
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanLines)

	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}
	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}
	return lines, true
}

func writeFile(avg float64, what bool) bool {
	var writeAvg string
	if what {
		writeAvg = "avgOfLine.txt"
	} else {
		writeAvg = "total.txt"
	}
	file, err := os.OpenFile(writeAvg,
		os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		log.Fatalf("WriteFile failed to open ")
	}

	defer file.Close()

	_, err = file.WriteString(fmt.Sprintf("%0.2f\n", avg))
	if err != nil {
		fmt.Print("Error: %v", err)
	}
	return true
}
func main() {
	lines, end := readFile()

	if !end {
		fmt.Println("Error")
	} else {
		var result float64 = 0
		var counter int
		var total float64
		for i := 0; i < len(lines); i++ {
			text := strings.Split(lines[i], "\t")
			for j := 0; j < len(text)-1; j++ {
				number, err := strconv.ParseFloat(text[j], 64)
				if err != nil {
					fmt.Println("Error!")
				}
				result += number
				counter++
			}
			avg := float64(result) / float64(len(text)-1)
			fmt.Println(i+1,". satırın ortalaması: ",  avg)
			total += result
			result = 0
			writeFile(avg, true)
		}
		totalAvg := float64(total) / float64(counter)
		fmt.Printf("\nToplam ortalama: %0.2f", totalAvg)
		writeFile(totalAvg, false)
	}

}
