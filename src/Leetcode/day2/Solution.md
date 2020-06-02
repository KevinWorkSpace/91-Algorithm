三色旗排序法 (Dutch national flag algorithm)
伪代码
我们使用三个指针：left, mid, right (left <= mid <= right)，数组元素可以分成四段，'[' 表示包括当前元素，'(' 表示不包括：

- [0, left) 是 bottom 元素
- [left, mid) 是 middle 元素
- [mid, right) 是待分堆的元素
- [right, end] 是 top 元素

遍历待分堆的元素，将它们归类：
```
// 当 [mid, right) 这个区间没有元素时停止遍历
while mid <= right:

  if array[mid] < middle:
    swap(mid, left)
    left++ // 维护 bottom 元素的边界
    mid++ // 换过来的是一个 middle 元素，不需要继续分类，所以下一次循环从 mid + 1 开始归类

  else if array[mid] > middle:
    swap(mid, right)
    right-- // 维护 top 元素的边界
    // 换过来的元素原本在 [mid, right) 区间中，是一个待分堆元素，所以下一次循环还是从 mid 开始归类

  else:
    mid++
    // 当前是一个 middle 元素，不需要交换，只要将 mid 右移一步扩大 [left, mid) 这个区间就行
  ```
图解
75_0

复杂度
Time：$O(n)$，最多遍历一次数组，所以时间复杂度$O(n)$。
Space: $O(1)$，直接在原数组上进行修改，没有用到额外空间，所以空间复杂度是 $O(1)$。
代码
JavaScript Code
```javascript
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
  const swap = (list, p1, p2) => [list[p1], list[p2]] = [list[p2], list[p1]]
  let red = 0,
    blue = nums.length - 1,
    p = 0

  while (p <= blue) {
    switch (nums[p]) {
      case 0:
        swap(nums, red++, p)
        p++
        break;
      case 1:
        p++
        break;
      case 2:
        swap(nums, blue--, p)
        break;
      default:
        break;
    }
  }
};
```
Python Code
```python
class Solution(object):
  def sortColors(self, nums):
    """
    :type nums: List[int]
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    midKey = 1
    left, mid, right = 0, 0, len(nums) - 1
    while mid <= right:
      if nums[mid] < midKey:
        nums[mid], nums[left] = nums[left], nums[mid]
        mid += 1
        left += 1
      elif nums[mid] > midKey:
        nums[mid], nums[right] = nums[right], nums[mid]
        right -= 1
      else:
        mid += 1
```
Two-pass
第一遍遍历数组，使用 colorCount 数组记录颜色出现次数，数组下标表示颜色，值表示相应颜色出现的次数；
按照颜色出现的次数，按顺序分别往 nums 数组中填充颜色。
也可以用一个 map 来记录颜色出现的次数。
```javascript
function sortColor(nums) {
  const colorCount = Array(3).fill(0)
  nums.forEach(n => colorCount[n]++)
  let p = 0
  colorCount.forEach((count, color) => {
    while (count-- > 0) {
      nums[p++] = color
    }
  })
}
```