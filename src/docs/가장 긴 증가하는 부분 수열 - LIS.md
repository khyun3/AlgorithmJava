# LIS (Longest Increasing Subsequence)

## 개념

> LIS란 Longest Increasing Subsequence의 약자로, 주어진 수열에서 '오름차순'으로 이루어진 가장 긴 부분 수열을 의미합니다.

* 수열: 여러 수가 순서대로 나열된 것
* 부분 수열: 수열에서 일부 원소를 골라낸 것 (연속일 필요 없음, 순서는 유지해야 함)
* 증가: 앞에 있는 수보다 뒤에 있는 수가 더 커야 함 (같은 값은 인정하지 않음)
* 최장: 가능한 한 길게

## 예시

* 주어진 수열:
* `[10, 20, 10, 30, 20, 50]`

가능한 증가 부분 수열 중 예를 들면:

```
[10, 20, 30, 50]
[10, 20, 50]
[10, 30, 50]
```

이 중 가장 긴 것은 [10, 20, 30, 50]이고,
따라서 LIS의 길이는 4입니다.

## 핵심 포인트

* LIS는 원본 수열의 인접 여부는 신경 쓰지 않고, 순서만 유지합니다.
* 같은 값은 "증가"로 보지 않습니다. (엄격한 증가)
* 여러 개의 LIS가 존재할 수 있지만, 보통 문제에서는 길이만 묻거나, 하나의 경우를 구하도록 요청합니다.

# LIS를 구하는 대표적인 2가지 방법

## 1. 동적 프로그래밍 (DP)

### 아이디어
* 각 원소마다, 해당 원소를 마지막으로 하는 LIS의 길이를 저장합니다.
* 이전 원소들을 보면서 "나보다 작은 값" 중 가장 큰 LIS에 +1을 합니다.

### 점화식
* dp[i] = max(dp[j]) + 1 (단, j < i 이고 arr[j] < arr[i]인 경우)

### 시간 복잡도
* ```O(N²)```

### 예시 코드

```Java
class LIS_DP {
    public static void main(String[] args) {

        int[] arr = {10, 20, 10, 30, 20, 50};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int lisLength = Arrays.stream(dp).max().getAsInt(); //for문으로 대체 가능
        System.out.println(lisLength); // 출력: 4
    }
}
```

## 2. 이진 탐색 (Binary Search)

### 아이디어
* 실제 LIS를 만들진 않고, "가장 작은 값으로 유지되는" 가짜 LIS를 만듭니다.
* 수열을 순회하면서, 현재 수가 넣을 자리를 이진 탐색으로 찾습니다.
* 만약 현재 수가 가장 크다면 뒤에 추가하고, 그렇지 않으면 적절한 위치를 찾아 덮어씁니다.
### 동작 방식
배열을 유지하면서 현재까지의 "가능한 LIS"를 관리합니다.
lower_bound(현재 값 이상이 처음 나타나는 위치)를 찾아 값을 덮어씁니다.
### 시간 복잡도
* O(N log N)

### 예시 코드

```java
class LIS_BS {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 50};
        List<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) idx = -(idx + 1);
            if (idx == lis.size()) {
                lis.add(num);
            } else {
                lis.set(idx, num);
            }
        }
        System.out.println(lis.size()); // 출력: 4
    }
}
```
> 참고: 실제 lis 리스트에 들어 있는 수열은 진짜 LIS는 아니지만, 길이는 항상 맞습니다.

### 요약
|방법 | 시간 복잡도 | 특징|
|---|---|---|
|DP | O(N²) | 구현이 쉽고 이해하기 쉬움|
|이진 탐색 | O(N log N) | 빠르고 효율적이나 약간 까다로운 구현|