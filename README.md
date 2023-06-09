# <p align="center">持续更新中〽️🤗，欢迎一起探讨😊</p>

<div align="center">
<img src="https://img.shields.io/badge/Java-算法-ff5722.svg?colorB=00CD00" />
<img src="https://img.shields.io/badge/Java-设计模式-ff5722.svg?colorB=success" />
<img src="https://img.shields.io/badge/LeetCode-刷题-ff5722.svg?colorB=brightgreen" />
</div>

# <img src="https://img.shields.io/badge/!!!-笔记修复-ff5722.svg?colorB=ea1017" />
- 笔记由 Typora 编写，但 Typora 有些语法在 GitHub 上不支持:sweat_smile:
  - [x] 例如**下划线**
  - [ ] 例如**公式 `$$` 中的一些括号样式**
- 正在**逐步修复🤔**，以适应 GFM 语法

# Table of Contents

* [算法](#算法)
  * [质数](#质数)
  * [斐波那契数列](#斐波那契数列)
  * [递归](#递归)
* [细节](#细节)
* [妙题](#妙题)
* [LC_50💥💥💥](#lc_50)
* [LC_Array💥💥💥](#lc_array)
  * [二分法](#二分法)
    * [n](#n)
    * [mid](#mid)
    * [模板一](#模板一)
    * [模板二](#模板二)
    * [模板三](#模板三)
    * [总结](#总结)
    * [旋转数组](#旋转数组)
  * [滑动区间](#滑动区间)
  * [双指针的循环](#双指针的循环)
  * [排序](#排序)
    * [插入排序](#插入排序)
    * [快排](#快排)
    * [归并排序](#归并排序)
    * [堆排序](#堆排序)
    * [冒泡排序](#冒泡排序)
    * [选择排序](#选择排序)
    * [计数排序](#计数排序)
    * [桶排序](#桶排序)
    * [希尔排序](#希尔排序)
  * [模拟加法](#模拟加法)
  * [模拟乘法](#模拟乘法)
  * [模拟除法一](#模拟除法一)
  * [模拟除法二](#模拟除法二)
* [LC_Back💥💥💥](#lc_back)
  * [预先排序](#预先排序)
* [LC_Bit💥💥💥](#lc_bit)
  * [位运算](#位运算)
  * [位移运算](#位移运算)
  * [lowBit](#lowbit)
  * [去掉 lowBit](#去掉-lowbit)
  * [快速幂](#快速幂)
* [LC_DBFS💥💥💥](#lc_dbfs)
* [LC_DP💥💥💥](#lc_dp)
  * [01 背包](#01-背包)
    * [二维算法](#01背包二维算法) 
    * [一维算法](#01背包一维算法) 
    * [恰好装满](#恰好装满)
    * [恰好装满的组合数](#恰好装满的组合数)
      * [二维算法](#恰好装满二维算法)
      * [一维算法](#恰好装满一维算法)
  * [完全背包](#完全背包)
    * [二维算法](#完全背包二维算法)
    * [一维算法](#完全背包一维算法)
    * [方案数的组合排列](#方案数的组合排列)
  * [多重背包](#多重背包)
  * [回文](#回文)
* [LC_Greedy💥💥💥](#lc_greedy)
* [LC_Hash💥💥💥](#lc_hash)
  * [字母异位词](#字母异位词)
  * [路径前缀和](#路径前缀和)
  * [坐标 Hash](#坐标-hash)
  * [求交集](#求交集)
* [LC_LCP💥💥💥](#lc_lcp)
* [LC_Linked💥💥💥](#lc_linked)
  * [快慢指针一](#快慢指针一)
  * [快慢指针二](#快慢指针二)
  * [递归链接](#链表的递归链接)
* [LC_Offer_1💥💥💥](#lc_offer_1)
* [LC_Offer_2💥💥💥](#lc_offer_2)
* [LC_Offer_3💥💥💥](#lc_offer_3)
* [LC_SQ💥💥💥](#lc_sq)
  * [堆](#堆)
* [LC_String💥💥💥](#lc_string)
* [LC_Tree💥💥💥](#lc_tree)
  * [遍历](#遍历)
  * [递归链接](#树的递归链接) 
  * [二叉搜索树  BST](#二叉搜索树--bst)
  * [深度高度](#深度高度)
  * [最近公共祖先](#最近公共祖先)
* [在线输入输出练习](#在线输入输出练习)
* [设计模式](#设计模式)
* [UML 类图](#uml-类图)
* [UML 类图箭头](#uml-类图箭头)
* [原则](#原则)
  * [单一职责原则](#单一职责原则)
  * [开闭原则（目标）](#开闭原则)
  * [里氏代换原则（基础）](#里氏代换原则)
  * [依赖倒转原则（手段）](#依赖倒转原则)
  * [接口隔离原则](#接口隔离原则)
  * [合成复用原则](#合成复用原则)
  * [迪米特法则](#迪米特法则)
* [创建型](#创建型)
  * [简单工厂模式](#简单工厂模式)
  * [工厂方法模式](#工厂方法模式)
  * [抽象工厂模式](#抽象工厂模式)
  * [建造者模式](#建造者模式)
  * [原型模式](#原型模式)
  * [单例模式](#单例模式)
* [结构型](#结构型)
  * [适配器模式](#适配器模式)
  * [桥接模式](#桥接模式)
  * [组合模式](#组合模式)
  * [装饰模式](#装饰模式)
  * [外观模式](#外观模式)
  * [享元模式](#享元模式)
  * [代理模式](#代理模式)
* [行为型](#行为型)
  * [职责链模式](#职责链模式)
  * [命令模式](#命令模式)
  * [解释器模式（略）](#解释器模式)
  * [迭代器模式](#迭代器模式)
  * [中介者模式](#中介者模式)
  * [备忘录模式](#备忘录模式)
  * [观察者模式](#观察者模式)
  * [状态模式](#状态模式)
  * [策略模式](#策略模式)
  * [模板方法模式](#模板方法模式)
  * [访问者模式](#访问者模式)
* [技巧🔞🔞🔞](#技巧)
* [符号](#符号)
* [无倦💥💥💥](#无倦)
* [遗留难题](#遗留难题)
* [遗留方法](#遗留方法)




# 算法

> - 文件夹 `LC_Office_1 == 《剑指 Offer （第 2 版）》` 
> - 文件夹 `LC_Office_2 == 《剑指 Offer （专项突击版）》` 
> - 文件夹 `LC_Office_3 == 《程序员面试金典 （第 6 版）》` 



## 质数

> - `1` 既不是质数也不是合数
> - **质因数分解定理</ins>**：任何一个 `> 1` 的合数都可以**唯一地分解为有限个质数的乘积**

- 简单判断质数
  - 合数 `n` $\Rightarrow$ 必有 $\leqslant \sqrt{n}$ 的质因子（若 `n = p * q` $\Rightarrow$ 必有 $p \leqslant \sqrt{n}$ 或者 $q \leqslant \sqrt{n}$ ）
  - 没有 $\leqslant \sqrt{n}$ 的质因子 $\Rightarrow$ 质数 `n`（**逆否命题</ins>**）（只需遍历 $[2 , \sqrt{n}]$ 中的质数，没有可以整除的即可）
- 埃氏筛见 `Solution_204.java` 



## 斐波那契数列

> - 从 `0 、1 、1 、2 、...` 开始



## 递归

> - 递归要想清楚**递归边界**和**返回值** 
> - 递归边界通常是**想要的结果的值的来源**（详见 `LC_Tree` 的 `Solution_404`）



# 细节

> - 判断浮点数的**小数部分**是否为 `0` 可用 `double % 1.0`（见 `StreamMain.java` 代码）
> - 注意 `-Integer.MIN_VALUE` **会溢出**，且 `Integer.MIN_VALUE / -1` **也会溢出** 
> - **溢出结果**还是 ` == Integer.MIN_VALUE`（例如 `Solution_29` 和 `Solution_166` ，涉及乘法 `&` 除法的问题都要注意）
> - 通常取 `+∞ == 0x3f3f3f3f` 为 $1\times10^9$ 与 `Integer.MAX_VALUE` 同为 10 亿级别，且 `∞ + ∞` 不溢出（[见下述输入输出练习](#在线输入输出练习)）
> - `null == null` 返回 `true` 
> - 初始化二维数组用 `{{...} , {...} , ...}` 而不是 `[[...] , [...] , ...]` 
> - 赋值语句 `=` 的返回值就是赋值后左边变量的值
> - 连续的 `n` 个整数中，必有且仅有一个数能除尽 `n` 

- 整数相除 `/` 
  - 利用**数轴**上 `x` 的倍数**理解** 
  - 向下取整：`x / y` 向 `0` 取（直接抹去小数部分）
  - 向上取整：`(x + y - 1)/y == (x - 1)/y + 1 ` 向 `-∞ 、+∞` 取（[见下建堆](#堆)）
- 从左到右计算 `++ 、--` 的陷阱
  - `(x ...) ... (x++)`（前面的 `x` 还未自增 `1`）
  - `(x++) ... (x ...)`（后面的 `x` 已经自增 `1` 了）



# 妙题

> ```
> 【LC_50】Codec 、
> 
> 【LC_DP】474 、647 、132 、213 、337 、32 、152 、718 、413
> 
> 【LC_DBFS】638 、130 、289 、463 、
> 
> 【LC_Hash】621 、554 、76 、451 、128 、454
> 
> 【LC_Array】69 、153 、154 、378 、11 、581 、75 、73 、448 、137 、260 、287 、202 、29
> 
> 【LC_Linked】160 、141 、142 、138 、206
> 
> 【LC_LCP】7 、33
> 
> 【LC_Bit】50 、326 、338 、318
> 
> 【LC_String】3 、179 、
> 
> 【LC_Tree】145 、669 、538 、230 、572 、114 、222 、110 、513 、235 、236 、437 、124 、543 、404
> 
> 
> 【做难事必有所得】
> 
> 求逆序对：315 + Offer_1_51（官方图解很不错）（可以逆序排序也可以正序排序）
> 
> 链表的迭代式归并和递归式归并：23 + 148（见官方解析：时间复杂度和空间复杂度）
> 
> 拓扑排序：Offer_2_114（根据单词顺序 ==> 还原出字符顺序，每两个相邻的 word 贡献一条有向边）





# LC_50



# LC_Array



## 二分法

> - **本质**：每次**排除一半**无效区间，**保留一半**有效区间
> - 时间复杂度为 `O(logn)` 级别
> - 细节是要保证对新的有效区间搜索语义一致

### n

> - `nums[]` 的长度为 `n` 
> - `  n / 2` 表示始终取一半（偶数）或一半少一个（奇数）
> - `(n+1) / 2` 表示始终取一半（偶数）或一半多一个（奇数）
> - **用数轴很容易理解** 



### mid

> - 两种方法在 `[l , r]` 区间长度为奇数时，都取**正中间** 

- **向下取整** $\Rightarrow$ `l + ((r - l) >> 1)  == (l + r) / 2 == l + (r - l) / 2`（中间式子的 `+` 容易**溢出**，改为左右两边的 `-` 较好）
  - 即在 `[l , r]` 区间长度为偶数时，取中间偏左
  - 适合于模板一和模板二（模板二中有 `r = mid` ，若向上取整，对于长度为 `2` 的 `[l , r]` 会陷入死循环）
- **向上取整** $\Rightarrow$ `(l + r + 1) >> 1` 
  - 即在 `[l , r]` 区间长度为偶数时，取中间偏右
  - 适合于模板一和模板三（模板三中有 `l = mid` ，若向下取整，对于长度为 `2` 的 `[l , r]` 会陷入死循环）



### 模板一

> - 判断元素 `target` 是否存在，存在则返回其下标，不存在则返回 `-1` 

- 初始化 `[l , r] == [0 , n - 1]` **有效区间** $\Rightarrow$ 判断 `target` 是否在该**有效区间**内
- 循环 `while (l <= r)` 最后在 `l == r` 时**还需判断**是否有 `nums[l] == nums[r] == target` 
- 若 `nums[mid] != target` 则 `l = mid + 1` 或者 `r = mid - 1` $\Rightarrow$ 即也排除了 `mid` 



### 模板二

> - 找第一个 `target <= 元素` 及其下标，`r` 向 `mid` 收缩
> - 找第一个 `target >= 元素 & < & >` 也都可以，语义本质是**找第一个** 

- 初始化 `[l , r] == [0 , n]` $\Rightarrow$ 考虑到 `所有元素 < target` $\Rightarrow$ 则第一个 `target <= 元素` 下标应该为 `n`（无效下标）
- 循环 `while(l < r)` 当 `l == r` 时即**夹逼出了**目标位置
  - $\Rightarrow$ 由于第一个 `target <= 元素` 其下标**必然**在 `[l , r] == [0 , n]` 内
  - $\Rightarrow$ 所以**必然**找得到
  - $\Rightarrow$ 即当循环结束时**必然**有 `l == r` 且为目标位置：第一个 `target <= 元素` 的下标
- 当 `target <= nums[mid]` 时应该有 `r = mid` ，因为此 `nums[mid]` 有可能就是第一个 `target <= 元素` $\Rightarrow$ 所以也应该**向下取整** 
  - 否则 `l = mid + 1` 
- 最后还要**特判一下** `l == r` 该位置是否为 `n` 以及是否恰好 `target == 元素` 



### 模板三

> - 找最后一个 `元素 <= target` 及其下标，`l` 向 `mid` 收缩
> - 找最后一个 `元素 >= target & < & >` 也都可以，语义本质是**找最后一个** 

- 初始化 `[l , r] == [-1 , n-1]` $\Rightarrow$ 考虑到 `target < 所有元素` $\Rightarrow$ 则最后一个 `元素 <= target` 下标应该为 `-1`（无效下标）
- 循环同上模板二 $\Leftrightarrow$ **必然**找得到
- 当 `nums[mid] <= target` 时应该有 `l = mid` ，因为此 `nums[mid]` 有可能就是最后一个 `元素 <= target` $\Rightarrow$ 所以也应该**向上取整** 
  - 否则 `l = mid + 1` 
- 最后也要特判下，同上模板二



### 总结

> - 模板一要判断**是否存在**，所以需要 `while(l <= r)` ，且要判断 `if (nums[mid] == target)` 若存在则直接返回（**建议最优先判断**）
> - 模板一的 `l & r` 的初始化需**覆盖给定的搜索范围** 
> - 模板二 `&` 模板三**一定存在**，所以仅需 `while(l < r)` ，然后不断夹逼 `l & r` 即可
> - 模板二 `&` 模板三的 `l & r` 的初始化的**根本原则**：要保证 `[l , r]` **覆盖所有可能的返回值**，尽管可能指向的是无效下标
> - **突破模板**：搞清楚逻辑 $\Rightarrow$ 每次排除哪一半 $\Rightarrow$ 确定 `l & r` 的收缩变化 $\Rightarrow$ 再选择不会陷入死循环的 `mid` 的计算方式



### 旋转数组

> - `nums[k] , nums[k+1] , ... , nums[n-1] , nums[0] , nums[1] , ...  , nums[k-1] ` 
> - 前半段有序$\nearrow$  `+`  后半段有$\nearrow$ （且前半段比后半段值更大）
> - 仅**中间某一处** `nums[n-1]` 和 `nums[0]` 处递减，称为旋转间隙
> - **无论是**向上还是向下取整一分为二 $\Rightarrow$ **总是**一边有序，一边无序（含重复元素 `&` 未旋转情况见下详述）
> - **重点**就是判断哪边有序 $\Rightarrow$ 然后判断 `target` 是否在**该有序区间的一边内** $\Rightarrow$ 不在就选择另一边

- 图例化所有可能的布局
  - ①：`[l ... 旋转间隙 ... mid ... r]`（此时 `[l , mid]` 无序，有重复元素情况需考虑该布局，需执行 `l++ & r--` **打破该布局**）
    - 必有 `nums[l] >= nums[mid] <= nums[r]` 
  - ②：`[l ... mid ... 旋转间隙 ... r]`（求最小元素遇到此布局，需执行 `r--` 而不能直接 `r = mid`）
    - 必有 `nums[l] <= nums[mid] >= nums[r]` 
  - ③：`[l ... mid ... r]`（旋转点在之前的循环中已经排除掉了，**或**本来就没有旋转，**或**旋转回原顺序了）
    - 必有 `nums[l] <= nums[mid] <= nums[r]` 
- 无重复元素搜索是否存在（`Solution_33`）
  - 对任意区间 `[l , r]` **向下取整**求 `mid`（有可能 `l == mid`）
  - 情况一：若 `nums[l] <= nums[mid]` $\Rightarrow$ 则 `[l , mid]` 必有序（此时必是 ② ③ 布局）
  - 情况二：若 `nums[l]  > nums[mid]` $\Rightarrow$ 则 `[mid , r]` 必有序（此时必是 ① 布局）
- 有重复元素搜索是否存在（`Solution_81`）
  - 对任意区间 `[l , r]` **向下取整**求 `mid`（有可能 `l == mid`）
  - 情况一：若 `nums[l] <= nums[mid]` $\Rightarrow$ **还要细分**为三种情况
    - 小一：若严格小于 `nums[l] < nums[mid]` $\Rightarrow$ 则 `[l , mid]` 必有序（此时必是 ② ③ 布局）
    - 小二：`nums[l] == nums[mid] && nums[mid] != nums[r]` $\Rightarrow$ 则 `[l , mid]` 必有序（此时必是 ② ③ 布局）
    - 小三：`nums[l] == nums[mid] && nums[mid] == nums[r]`
      - $\Rightarrow$ 此时有可能是 ① ② ③ 任一布局
      - $\Rightarrow$ **无法得出** `[l , mid]` 必有序，**也无法得出** `[mid , r]` 必有序
      - $\Rightarrow$ **只能执行** `l++ & r--` 以进一步缩小**有效区间** 
      - $\Rightarrow$ 因为肯定已经判断完 `nums[mid] != target` 了，留着 `nums[l]` 和 `nums[r]` 也没用
  - 情况二：若 `nums[l]  > nums[mid]` $\Rightarrow$ 则 `[mid , r]` 必有序（此时必是 ① 布局）
- 无重复元素搜索最小值（`Solution_153`）$\Rightarrow\left\{\begin{aligned}&官方图解非常棒\Rightarrow优先以\ nums[r]\ 为判断基准\\&没必要强行解释为模板\end{aligned}\right.$  
- 有重复元素搜索最小值（`Solution_154`）$\Rightarrow\left\{\begin{aligned}&官方图解非常棒\Rightarrow优先以\ nums[r]\ 为判断基准\\&没必要强行解释为模板\\&同\ Solution\_81\ 无法判断、无法排除一半，只能\ \text{r--}\ 进一步缩小有效区间\end{aligned}\right.$  



## 滑动区间

> - 通常是要找**满足条件**的**连续**子数组 `&` **连续**子串
> - **滑动** `r` $\Rightarrow$ **不满足**条件了 $\Rightarrow$ **收缩** `l` $\Rightarrow$ 直到满足（`Solution_713 、438 、3 、395`）
> - **滑动** `r` $\Rightarrow$ **恰满足**条件了 $\Rightarrow$ **收缩** `l` $\Rightarrow$ 寻找更优（`Solution_209 、76`）
> - 也可以理解为求以下标 `r` 为结尾的最优的**连续**子数组 `&` **连续**子串
> - [见下述字母异位词](#字母异位词)   



## 双指针的循环

> - `while(指针一 && 指针二)`：循环**结束后**，需要注意某个指针是否**还没遍历完** 
> - `while(指针一 || 指针二)`：在循环**内部**，需要注意某个指针是否**已经遍历完** 

- 在同个数组中 `l` 从 `0` 开始向后遍历，`r` 从 `n-1` 开始向前遍历
- 此时循环一般为 `while(l < r)` ，且循环内部也要注意 `while(l < r)` 或 `if(l < r)` 



## 排序

> - 插入排序和快排在确定一个元素的最终位置时，总是应该用一个 `ele` 或 `pivot` **预先存储该元素** 
> - 然后**制造出一个无效的空缺位置**，以方便移动其他的元素

### 插入排序

> - 将后面的无序部分 `nums[i+1 , n]` 元素**依次向前插入**前面的有序部分 `nums[0 , i]` 
> - 可以设置一个**阈值门槛**：若数组长度 `<= 7` ，则使用插入排序
> - 常作为快排和归并排序的**递归边界** 

### 快排

> - 每层**递归**确定一个枢轴元素 `pivot` 的**最终位置**（该枢轴元素应该**随机选取**，避免完全有序或者完全逆序的案例）
> - 左边都 `<= pivot` 
> - 右边都 `> pivot` 
> - 然后再**递归**排序左右两边（**递归边界**可以是插入排序或者 `l == r` ，但要保证**初始的** `[l , r]` 区间长度至少为 `1`）

### 归并排序

> - 与快排在**算法顺序性**上的区别：**先递归**排序左右两边 $\Rightarrow$ **再合并**有序的两边（**递归边界**可以是插入排序或者 `l == r` ）
> - 需要一个 `aux[]` **辅助数组**辅助 `merge` 合并
> - 合并是**稳定的** $\Rightarrow$ 可以在合并中**求逆序对** $\Rightarrow$（`Solution_315 & Solution__Offer_1_51`）
> - 链表的排序也经常使用归并，可以是**迭代式**归并 `&` **递归式**归并，**递归边界**为空链或单个结点，**等分两边**用快慢指针
> - **多路归并**：在多个已经排好序的子序列中，取每个子序列的最小 $\Rightarrow$ 得到全局最小（然后将该最小的下一个元素加入进来，重复之）

### 堆排序

> - [见下述堆](#堆)   
> - 向下调整：`root = max(root , root.left , root.right)` 

### 冒泡排序

> - [冒泡排序动态图解](https://www.runoob.com/w3cnote/bubble-sort.html)   
> - 比较 `&` 交换相邻的两个元素
> - 从左到右 $\Rightarrow$：每轮后最大的元素已经放置在**最终位置** 
> - 从右到左 $\Leftarrow$：每轮后最小的元素已经放置在**最终位置** 
> - 冒泡是稳定的，因为相邻两个元素等值时，不会进行交换

### 选择排序

> - [选择排序动态图解](https://www.runoob.com/w3cnote/selection-sort.html)   
> - 每次选择最小的放置在**最终位置** 
> - 选择是不稳定的，因为选择到最小的元素后，会直接交换到最终位置上，跨度很大，有可能导致等值元素的相对位置发生改变
> - 例如 `[6 7 6 2 8]` 第一次交换后变为 `[2 7 6 6 8]` 原来第一个元素的 `6` 会交换到第二个 `6` 的后面

### 计数排序

> - [计数排序动态图解](https://www.runoob.com/w3cnote/counting-sort.html)   
> - 创建 `bucket[value] = cnt` 
> - 有序的下标 `==` 待排序元素
> - 需要先找出待排序元素的最大值 `maxValue` 以建桶 `bucket[maxValue + 1]` 

### 桶排序

> - [桶排序动态图解](https://www.runoob.com/w3cnote/bucket-sort.html)   
> - 计数排序的升级

### 希尔排序

> - [希尔排序动态图解](https://www.runoob.com/w3cnote/shell-sort.html)   





## 模拟加法

> - 加法
> - 总和：` sum = a + b + up` 
> - 位值：` sum % 10` 
> - 进位：`up = sum / 10` 
> - 循环结束后可能还需要处理进位 `up` 



## 模拟乘法

> - `nums1[0]` 与 `nums2[0]` 为最高位
> - `nums1[i]` 与 `nums2[j]` 相乘
> - 最多为两位
> - **高位**在 `res[i+j]` 
> - **低位**在 `res[i+j+1]` 
>
> ```
> xxx       0 1 2
>  yy         0 1
> res   0 1 2 3 4

- `n` 位的整数与 `m` 位的整数相乘
- 结果的**最少位数** $\Rightarrow$ `n + m - 1` 位
  - 假设 `n` 位的整数为一个 `1` 后面 `n-1` 个 `0` 
  - 假设 `m` 位的整数为一个 `1` 后面 `m-1` 个 `0` 
- 结果的**最多位数** $\Rightarrow$ `n + m` 位
  - 假设 `n` 位的整数为 `n` 个 `9` 
  - 假设 `m` 位的整数为 `m` 个 `9` 
  - 则 `n * m` 的位数必然少于 `(n+1) * (m+1)` 共 `n + m + 1` 位



 $\Rightarrow$ 



## 模拟除法一

> - 模拟 `a / b` 向下取整，整除，直接去掉小数部分，不能使用 `/ 、* 、%` 

- 看 `a` 中有多少个 `b` 
  - **倍增法** `+=`：`b` 倍增为 `2b 、4b 、8b 、...` 
  - 注意各种**溢出细节**，例如减法比加法更健壮，要警惕加法
  - 通常是双 `while` 循环
  - 举例如 `20 / 3` 
    - 第一轮内循环 `while`：`3` 倍增为 `6 、12` 停止 $\Rightarrow$ `20` 变为 `8` 
    - 第二轮内循环 `while`：`3` 倍增为 `6`停止 $\Rightarrow$ `20` 变为 `2` 



## 模拟除法二

> - $\frac{a}{b}$ 整式除法：结果要么为**有限小数**，要么为**无限循环小数** 
> - 核心流程：先 `/ b` 得到**位值** $\Rightarrow$ 再 `% b` 得到**余数** $\Rightarrow$ 对**余数** `* 10` $\Rightarrow$ 回到第一步重复之
> - 若遇到余数为 `0` $\Rightarrow$ 结果为有限小数
> - 若遇到重复余数 $\Rightarrow$ 结果为无限循环小数（重复余数用 `Map<余数 , 下标>` 记录）





# LC_Back

> - 回溯的本质是**枚举** $\Rightarrow$ 枚举所有可能性
> - 回溯是递归的**副产品** $\Rightarrow$ 只要有递归就会有回溯 $\Rightarrow$ **回溯到本层重新选择一个** 
> - 组合无序：顺着 `nums[startIndex , ... , n-1]` 取，**只能往后取**不能往前取，每种组合保持在 `nums[]` 中的相对顺序
> - 排列有序：不再需要 `startIndex` ，每层都需从头到尾遍历 `[0 -> n-1]` **可以往前取**之前未被取过的（需用 `used[]` 记录）
> - 同层去重：**同一层**的 `back()` 中不能重复取相同的元素，但**不同的层**是可以重复选取值相同而位置不同的元素的

- $C_n^m = \frac{n!}{m!\ (n-m)!}$ 
- $A_n^m = \frac{n!}{(n-m)!}$ 
- 两类**同层去重**技巧
  - **预先排序**可方便同层去重
  - **可以**预先排序的去重：`Solution_90 、40 、47`（排列的同层去重比组合的多了一个 `!use[i-1]` 条件判断上层是否选取过 `nums[i-1]`）
  - **不可**预先排序的去重：`Solution_491`（每层定义一个 `Set` 判断同层是否重复选取了）
- 常用**优化剪枝**技巧
  - 每层至少还要够有 `...` 个数选
  - 每层至多需要分割 `...` 个字符
  - 本层分割的短子串无效，则再分割长子串也无效
  - 预先排序 $\Rightarrow$ 后续可选元素应该 `<= sum` 
- 搜索回溯的<font style="color:red">顶级优化：正难则反，逆向思维</font> 
  - 详见 `Solution_79` 
  - 选择**搜索入口更少**的顺序搜索（正序搜索 `&` 逆序搜索）



## 预先排序

> - 方便找组合 、去重 、剪枝优化
> - 详见 `LC_Hash` 的 `Solution_15` 全用上了



# LC_Bit

> - 进制**位权**：从右到左 $\leftarrow$，位数从 `0` 开始，每位代表的**位权值** == $\text{进制}^{\text{位数}}$（小数点部分，从左到右，位数从 `-1` 开始）

- **十进制**的有符号右移
  - **取得**个位数：`x % 10` 
  - **移除**个位数：`x / 10` 



## 位运算

> - `... 、 2 、  1 、  0` $\Leftarrow$ 二进制从右到左**位编号** 
> - `... 、2^2 、2^1 、2^0` $\Leftarrow$ 二进制从右到左**位权值** 
> - `1 hex = 4 bit` 

- 按位 `&` 
  - `任何 & 0 == 0` 
  - `任何 & 1 == 任何` 
  - 常用于**取特定的位**，其他位都置为 `0`（详见 `Integer` 源码及其中的 `& 与 %` :stars: ）
  - `0x3 == 0011 、0x5 == 0101 、0xf == 1111` 
  - `0xc == 1100 、0xa == 1010` 
  - 取奇数位 == 无符号右移 `>>>` 后取偶数位
- 按位或 `|` 
  - `任何 | 1 == 1` 
    - 常用于**置特定的位**为 `1` 
    - 例如 `target |= (1 << i)` 将 `target` 的第 `i` 位置为 `1` 
  - `任何 | 0 == 任何` 
    - 常用于不同位置的**字节拼接** 
- 按位异或 `^` 
  - 相同为 `0`，不同为 `1`（详见 `Math` 源码）
  - `a ^ a == 0`（与自身异或，始终为 `0` ）
  - `a ^ 0 == a`（与 `0` 异或，始终为自身）
    - 异或满足**交换律**和**结合律** $\Rightarrow$ 不管位置顺序，同一批数异或的结果一定是一样的
  - `任何 ^ 1 == 任何的取反` 
    - 常用于**取反特定的位** 
    - 例如 `target ^= (1 << i)` 将 `target` 的第 `i` 位进行取反
    - 例如 `(a ^ -1) == ~a` 
- 按位取反 `~` 
  - `~ 0 == 1` 
  - `~ 1 == 0` 
  - 最高位的符号位也会取反



## 位移运算

> - 左移 `<< n` 即 `* 2^n`（低位补 `0`）
> - 右移 `>> n` 即 `÷ 2^n`（高位补符号位）（**除得尽**的情况下）
> - 无符号右移 `>>> n`（高位补 `0`）

- 除不尽的情况下
  - `x` 为正数：`x / 2^bit  ==  x >> bit`（<font style="color:red">`/` 的商总是向 `0`</font>  ）
  - `x` 为负数：`x / 2^bit  ==  x >> bit + 1`（<font style="color:red">`>>` 的商总是向 `-∞`</font>  ）
  - 详见 `LC_Bit` 的 `Note.java` 代码
- 引申一下
  - 复杂运算的中间值多求 `%` 总是好的
    - `(a + b) % p = (a % p + b % p) % p` 
    - `(a - b) % p = (a % p - b % p) % p` 
    - `(a * b) % p = (a % p * b % p) % p` 
  - 取余 `x % y  ==  x - y * (x / y)`（<font style="color:red">其中 `(x / y)` 商向 `0` 取</font>）（结果符号同 `x`）（<font style="color:red">可以理解为先计算 `|x| % |y|` 然后加上 `x` 的符号</font>）
  - 取模 `x m y  ==  x - y * (x / y)`（<font style="color:red">其中 `(x / y)` 商向 `-∞` 取</font>）（结果符号同 `y`）（`m == mod`）
  - 当 `(x / y)` **除得尽**的时候 $\Rightarrow$ 即 `x` 是 `y` 的倍数，则取余和取模的结果都为 `0` 
  - 当 `(x / y)` **除不尽**的时候 $\Rightarrow$ **当且仅当** `x` 与 `y` 的**符号相同**，即 `(x / y)` 为正，向 `0` 或 `-∞` 取都一样，才有 `x % y == x mod y`
  - 详见 `Beginning.java` 的 `Rem_Mod()` 函数



## lowBit

> - 详见 `LC_Bit` 的 `Note.java` 代码
> - 取二进制中最低位的 `1` 
> - 即使 `x == Integer.MIN_VALUE` 也无所谓，**也能得到**最低位的 `1` 

- 方法一：`x & -x` 
  - `x = ...1000` 
  - `-x = 取反 + 1` 
  - ​      `= ...0111 + 1`（高位的 `...` 也都按位取反了）
  - ​      `= ...1000` 
  - `x & -x = ...1000`（高位的 `...` 按位取反后相与都为 `0` 了）
- 方法二：`x & (x ^ (x - 1))` 
  - `x = ...1000`  
  - `x - 1 = ...0111`   
  - `x ^ (x - 1) = ...1111`（高位的 `...` 都异或为 `0` 了）
  - `x & (x ^ (x-1)) = ...1000` 



## 去掉 lowBit

> - 去掉二进制中最低位的 `1` 
> - `x & (x - 1)` 
> - `x = ...1000` 
> - `x-1 = ...0111` 
> - `x & (x-1) = ...0000`（高位的 `...` 与自身相与结果不变）
> - 即使 `x == Integer.MIN_VALUE` 也无所谓，**也能去掉**最低位的 `1` 



 $\Rightarrow$ 





## 快速幂

> - 幂 $\Rightarrow$ 二进制 $\Rightarrow$ **分解** 

- `x ^ {15} == x ^ {1111} == x ^ {1 + 10 + 100 + 1000} == x^{1} * x^{10} * x^{100} * x^{1000}` 
- 从右到左 $\leftarrow$ 遍历幂的每一位 `bit` ，分解后的幂值为：`1 、2 、4 、...` 
- 即 `x^{1} * x^{10} * x^{100} * x^{1000} == x^{1} * x^{2} * x^{4} * x^{8}` 
- 即 `x` 需**倍增相乘** 
- 但遍历到 `bit == 0` 则**只需倍增** `x` 而**无需相乘** 





# LC_DBFS

> - 记忆化 `memo` 避免重复计算，且**每层要能确定**一个 `memo` 记录
> - 广搜层思想：通常定义**目标层**为第 `0` 层，且更新完**层数**就入队，出队时**用以更新其下一层**的层数

- 树的层序遍历和广搜层思想
  - 待访问的入队列，需要最先访问的最先入队列（根节点 `&` 目标层 `&` 第 `0` 层）
  - 出队列时访问之，且更新其下一层的层数 `+1` 然后再都加入队列
  - 不能重复入队（`boolean inQ[]`）
- **同步更新**技巧：高位标记新状态，低位保存原始状态（详见 `Solution_289.java` 和 `Solution_73.java`）
- 有向图拓扑排序
  - 邻接表：每个节点 `-->` 哪些节点
  - 入度表：每个节点 `<--` 多少节点





# LC_DP

> - [动态规划五部曲：`dp` 数组及下标含义 $\Rightarrow$ 状态转移方程 $\Rightarrow$ 遍历顺序 $\Leftrightarrow$ 初始化](https://programmercarl.com/动态规划理论基础.html)   
> - 大部分时候需要**先**确定遍历顺序才能理解如何初始化
> - 初始化的核心在于那些**无法**通过状态转移方程自动更新计算的 `dp` 部分需要手动初始化

- [背包问题（代码见 `LC_DP` 包中的 `Note.java`）](https://programmercarl.com/背包理论基础01背包-1.html)   
  - 物品体积 `w` 
  - 物品价值 `v` 
  - 背包容量为 `W` $\Rightarrow$ 要求装得下且**总价值最大化**（**总价值最小化**就是将所有的 `max` 改为 `min` 即可）

## 01 背包

> - 每个物品**只有一个** 
> - <font style="color:red">规定：二维算法统一 `i` 为行 `j` 为列</font> 

### <span id='01背包二维算法'>二维算法</span>

- 含义：`dp[i][j]` 表示从**下标**为 `[0-i]` 的物品里面取，放进**容量**为 `j` 的背包，能装得下的最大价值总和
- 状态转移
  1. 放不下物品 `i` ：`j < weight[i]` $\Rightarrow$ `dp[i][j] = dp[i-1][j]` 
  2. 放得下物品 `i` ：`j >= weight[i]` $\Rightarrow$ `dp[i][j] = max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i] )`（放 `i` 和不放 `i` 取最大值）
     - <font style="color:red">项分析 $\Rightarrow$ 确保正上方和左上方都已经更新计算过了</font> 
     - 正上方 `dp[i-1][j]` 
     - 左上方 `dp[i-1][j-weight[i]] + value[i]` 
- 遍历顺序
  - `i` 必须正序遍历 $\Rightarrow$ 且 `i=0` 第一行**无**正上方和左上方，**需手动初始化** $\Rightarrow$ 即 `i` 正序遍历 `[1 -> n-1]` 
  - `j` 无所谓，上面的 `i-1` 层已经更新计算完即可 $\Rightarrow$ 即 `j` **可正可逆**遍历 `[0 ~ W]` 
  - <font style="color:red">策略一 $\Rightarrow$ 外层正序遍历 `i` ，内层 `j` 遍历顺序无所谓</font> 
  - <font style="color:red">策略二 $\Rightarrow$ 外层正序遍历 `j`（确保左上方） ，内层正序遍历 `i`（确保正上方） </font> 
- 初始化
  - `dp[0][j]` 第一行，看容量 `j` 装不装得下下标为 `0` 的物品
  - 即将 `dp[0][weight[0]]` **及其之后**都初始化为 `value[0]` 



### <span id='01背包一维算法'>一维算法</span>

> - 滚动数组，空间优化，通常采用去 `i` 维留 `j` 维，即**只有一行** 
> - 由上述二维算法的**项分析**可知<font style="color:red">一维算法的项分析：</font> 
> - 正上方的 `dp[i-1][j]` 即一维中的**自身旧值** `dp[j]` 
> - 左上方的 `dp[i-1][j-weight[i]]` 即一维中的**正左方旧值** `dp[j-weight[i]]` 
> - 所以 `j` 必须逆序遍历 $\Rightarrow$ **避免破坏旧值** 

- 含义：`dp[j]` 表示容量为 `j` 的背包能装得下的最大价值总和
- 状态转移：`j >= weight[i]` $\Rightarrow$ `dp[j] = max(dp[j] , dp[j-weight[i]] + value[i])`（在 `j < weight[i]` 时**自动遗传旧值**）
- 遍历顺序
  - `i` 可以从 `0` 开始正序遍历 `[0 , n-1]` ，因为第一遍 `i=0` 的遍历**效果等同于**上述手动初始化后的效果
  - `j` 必须逆序遍历 `[W -> weight[i]]` ，前面的 `[weight[i]-1 , 0]` 部分**自动遗传**旧值即可
  - <font style="color:red">唯一策略 $\Rightarrow$ 外层正序遍历 `i` ，内层 `j` 逆序遍历</font> 
    - **不能**先逆序遍历 `j` 
    - 因为此时左边列都还是 `0`，连所谓的正左方旧值都没有
- 初始化：分析至此，可知无需初始化
  - **二维化一维仅仅是空间的压缩，内核框架还是和二维算法一模一样** :stars: 
  - **甚至在某些其他的题型里面，可能需手动去除无效遗留旧值的影响** :stars: 
  - 例如对应的二维算法在某些情况下必须有 `dp[i][j] == 0` ，二维数组的默认值为 `0` 
  - 但一维算法必须在滚动过程中**手动更新** `dp[j] == 0` $\Rightarrow$ 以避免遗传旧值的影响 $\Rightarrow$ 例如 `Solution_63 、 413 、718` 等



### 恰好装满

> - 修改一维算法的初始化值**即可** 
> - 要求必须装满的情况下**总价值最大**：初始化 `dp[0] = 0` 且其他为 `-∞`（代表一种背包装不满**无效状态**）
> - 要求必须装满的情况下**总价值最小**：初始化 `dp[0] = 0` 且其他为 `+∞`（代表一种背包装不满**无效状态**）
> - `dp[j] == ±∞` 表示前 `i-1` 个物品装不满容量 `j` 
> - `dp[j-weight[i]] == ±∞` 表示装入当前 `i` 物品后前 `i-1` 个物品也无法装满容量 `j-weight[i]` 
> - <font style="color:red">原则一：有效状态必须只能由有效状态推导得出</font> 
> - <font style="color:red">原则二：无效状态只能推导出无效状态，不能通过 `+ value[i]` 而累积转化为有效状态</font> 
> - <font style="color:red">原则三：`(... , ...)` 中只要存在一个有效状态时就必然要能推导出有一个效状态，不能被无效状态覆盖、抹灭</font> 
> - [背包恰好装满问题](https://blog.csdn.net/qq_42804678/article/details/81662367)   

- 一维算法中 `dp[j] = max(dp[j] , dp[j-weight[i]] + value[i])` 有如下几种状态
  - `dp[j] = max/min(无效状态 , 无效状态 + value[i])` 
  - `dp[j] = max/min(无效状态 , 有效 + value[i])` 
  - `dp[j] = max/min(有效 , 无效状态 + value[i])` 
  - `dp[j] = max/min(有效 , 有效 + value[i])` 
  - **最详细、最严谨、但最笨拙**的方法就是用 `if ... else if...` 将这四种情况全部都显式考虑出来，见 `Note.java` 代码
  - 下面介绍两种简化实现策略
- **总价值最大化**简化实现策略
  - 取 `-∞ == Integer.MIN_VALUE` 
  - 首先可以确定在 `value[i] > 0` 且属于 `int` 类型范围内时有 `Integer.MIN_VALUE + value[i]` 不会变号
  - 在一次计算中依旧能保持 `Integer.MIN_VALUE + value[i] < 0` 但有可能会非常接近 `0` 
  - 如果不加以控制的话，可能会慢慢积累转化为 `> 0` 变成有效状态
  - 所以每次更新计算 `dp[j]` 后若结果 `< 0` 则**立马重置**为 `Integer.MIN_VALUE` 即重置为 `-∞` 无效状态
  - 最后可以通过 `dp[j] == Integer.MIN_VALUE` 来判断容量为 `j` 的背包是否能恰好装满
  - <font style="color:red">但</font> 
    - 在某些题型里面，根据题意能得出任何容量的 `j` 都**必然能被装满** 
    - 则可以初始化 `dp[j] = 能已知的最坏情况 = 能已知的总价值最小的情况` $\Rightarrow$ 然后看是否还能装满成总价值更大的情况
- **总价值最小化**简化实现策略
  - 错误思路
    - 取 `+∞ == Integer.MAX_VALUE` 
    - 则 `Integer.MAX_VALUE + value[i]` 必然**溢出为负值** 
    - 则 `min(有效值 , Integer.MAX_VALUE + value[i])` 的情况中就会把该有效值**覆盖、抹灭**了
  - `bug` 最小的思路一
    - 取 `+∞ == 0x3f3f3f3f` 
    - **能也只能在绝大多数情况下**满足 `+∞ + value[i]` 不溢出为负值
    - 且每次更新计算 `dp[j]` 后若结果 `> +∞` 也**无需重置**为 `+∞` 了，因为求的是 `min` 
    - 最后可以通过 `dp[j] == 0x3f3f3f3f` 来判断容量为 `j` 的背包是否能恰好装满
  - <font style="color:red">`bug` 最小的思路二（例如 `Solution_322.java` 题）</font> 
    - 已知上限的情况下，取 `+∞ == 上限 + 1` 
    - 且依旧还是难以保证 `+∞ + value[i]` 不溢出为负值
    - 注意和下述的<font style="color:red">但</font>不同，这里还是无效状态，**上限虽然存在但不一定能取得到**，因为不一定能装满
  - <font style="color:red">但（例如 `Solution_279.java` 题）</font> 
    - 根据题意能得出任何容量的 `j` 都**必然能被装满** 
    - 则可以初始化 `dp[j] = 能已知的最坏情况 = 能已知的总价值最大的情况` $\Rightarrow$ 然后看是否还能装满成总价值更小的情况



### 恰好装满的组合数

> - `Solution_494.java` 
> - <font style="color:red">记住：不装任何东西，也是一种装法，也需要记为 `1` 种装法</font> 

#### <span id='恰好装满二维算法'>二维算法</span>

> - 对标 01 背包二维算法
> - 含义：`dp[i][j]` 表示从下标为 [0-i] 的物品里面取，放进容量为 `j` 的背包，**恰好装满有几种方式** 

- 状态转移：
  1. 放不下物品 `i` ：`dp[i][j] = dp[i-1][j]` 
  2. 放得下物品 `i` ：`dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i]]`（放 `i` 和不放 `i` 的**方案数相加**）
     - <font style="color:red">项分析 $\Rightarrow$ 确保正上方和左上方都已经更新计算过了</font> 
     - 正上方 `&` 左上方
     - 就是将比较总价值大小的 `max(...)` 函数换成了**累加方案数**的 `+` 函数
- 遍历顺序：[同 01 背包二维算法](#01背包二维算法) 
- 初始化:stars: 
  - 需要初始化 `i=0` 的第一行
  - 在 `nums[0] == 0` 的情况下
    - `dp[0][0] = 2`：选择 `nums[0]` 和不选择 `nums[0]` 都能装满容量为 `j=0` 的背包，方案数为 `2` 
    - `dp[0][j] = 0`：后续容量为 `j!=0` 的背包自然没法由 `nums[0]` 装满，方案数为 `0` 
  - 在 `nums[0] != 0` 的情况下
    - `dp[0][0] = 1`：不装 `nums[0]` 即能装满容量为 `j=0` 的背包，方案数为 `1` 
    - `dp[0][nums[0]] = 1`：物品 `nums[0]` 能装满容量 `j=nums[0]` 的背包，方案数为 `1` 
    - `dp[0][j] = 0`：其他容量的背包必然没法由 `nums[0]` 恰好装满，方案数为 `0` 

#### <span id='恰好装满一维算法'>一维算法</span>

> - 对标 01 背包一维算法
> - 自身旧值 `dp[j]` 和正左方旧值 `dp[j-weight[j]]` $\Rightarrow$ `dp[j] += dp[j-weight[i]]` 
> - <font style="color:red">需要先初始化 `dp[0] = 1`</font> $\Rightarrow$ 然后同 01 背包一维算法 `i` 正序遍历 `[0 -> N-1]` 且第一遍 `i=0` 的遍历**效果等同于**上述二维算法
> - <font style="color:red">唯一策略 $\Rightarrow$ 等同于 01 背包问题一维算法 $\Rightarrow$ 外层正序遍历 `i` ，内层 `j` 逆序遍历</font> 
> - **因为必须先遍历物品 `i` $\Rightarrow$ 所以只能求组合，不能求排列**（[详见下述完全背包方案数的组合排列](#方案数的组合排列)）



## 完全背包

> - 每个物品**有无限个** 

### <span id='完全背包二维算法'>二维算法</span>

> - 含义相同
> - 仅指出与 01 背包二维算法的不同之处

- 状态转移
  - 唯一区别在于将**左上方** `dp[i-1][j-weight[i]]` 改成了**正左方** `dp[i][j-weight[i]]` 
  - 因为放入 `i` 物品后还可以继续**重复放入** `i` 物品
  - <font style="color:red">项分析 $\Rightarrow$ 确保正上方和正左方都已经更新计算过了</font> 
- 遍历顺序
  - `j` 必须要正序遍历 `[0 -> W]` 
  - <font style="color:red">策略 $\Rightarrow$ 保证内层 `&` 外层都是正序遍历，先遍历 `i` 或 `j` 都可以</font> 
- 初始化
  - 也要手动初始化 `i=0` 第一行
  - 但需将 `dp[0][weight[0]]` **及其之后**都初始化为 `dp[0][j-weight[0]] + value[0]`（因为只要装得下**可以重复装入** `value[0]` ）



### <span id='完全背包一维算法'>一维算法</span>

> - 仅指出与 01 背包一维算法的不同之处
> - <font style="color:red">唯一区别</font> $\Rightarrow$ 此时的 `dp[j-weight[i]]` 应该为**正左方新值** 

- 遍历顺序
  - `j` 必须正序遍历 `[weight[i] -> W]` 
  - <font style="color:red">策略 $\Rightarrow$ 保证内层 `&` 外层都是正序遍历，先遍历 `i` 或 `j` 都可以</font> 
  - 此处不同于[ 01 背包一维算法的唯一策略](#01背包一维算法)  
  - **可以**先正序遍历 `j` 
  - 此时左边都已经是原二维数组最底下的行 `dp[n-1][< j]` 的新值了，虽然不是**正左方新值**，但是是**左下方新值** 
  - 可将 `dp[j-weight[i]] + value[i]` 理解为装入当前物品 `i` 且剩余容量 `j-weight[i]` 可装入 `[0 ~ n-1]` 任意物品所能得到的最大价值
  - 此时只有最后完全运算完后的一行才有意义
  - 也为下面的**排列**奠定了基础
- [恰好装满问题同 01 背包一样](#恰好装满) 



### 方案数的组合排列

> - 直接说一维算法
> - 类似于 01 背包的恰好装满组合数一维算法**对标** 01 背包的一维算法
> - 此处可**对标**完全背包的一维算法

- 初始化：`dp[0] == 1` 
- 状态转移：`dp[j] += dp[j - weight[i]]` 
- 组合
  - 外层正序遍历 `i` 从 `[0 -> N-1]` 
  - 内层正序遍历 `j` 从 `[weight[i] -> W]` 
  - 因为外层按**物品下标从小到大顺序依次遍历出现** 
  - 所以仅可能出现 `{... , nums[i-1] , nums[i] , ...}` 的方案
  - 而不可能出现 `{... , nums[i] , nums[i-1] , ...}` 这样的重复方案 $\Rightarrow$ 组合
- 排列
  - 外层正序遍历 `j` 从 `[weight[i] -> W]` 
  - 内层正序遍历 `i` 从 `[0 -> N-1]` 
  - 例如 `coins[i] == [1 ,5]` 且背包容量为 `W = 7` 
    - 当外层循环遍历到背包容量 `j = 6` 时，内层循环会进行如下两次累加
    - `dp[6] += dp[5]` 
      - 即把该重量为 `1` 的物品加入所有 `dp[5]` 的方案中，即为 `dp[6]` 的一部分方案
      - 其中肯定会累加 `1 + {5} == {1 ， 5}` 方案
    - `dp[6] += dp[1]` 
      - 即把该重量为 `5` 的物品加入所有 `dp[1]` 的方案中，即为 `dp[6]` 的一部分方案
      - 其中肯定会累加 `5 + {1} == {5 ， 1}` 方案



## 多重背包

> - 每个物品**数量不同** 
> - 把每个物品按其数量**一件一件展开** $\Rightarrow$ `new_weight[] & new_value[]` $\Rightarrow$ 01 背包问题





## 回文

> - 将字符串 `S` 倒置为 `S'` ，二者的公共子串不一定是回文串，**除非**：
> - 例如 `S = aba12` 倒置后 `S' = 21aba` 
> - 公共子串 `aba` 在 `S` 中位置为 `012` 
> - 公共子串 `aba` 在 `S'` 中位置为 `234` ，但倒置前即为 `012` ，即为回文串
> - **本质**：谁（子串）倒过来，和自己（位置）相同，谁才是回文子串





```
*      但求回文子序列可以这样做，无需下标位置匹配：
*          例如 516 的第三种方法
*          例如 S = 12xy21 倒置后 S' = 12yx21
*          最长回文子串长度：1
*          最长回文子序列长度：5
```





# LC_Greedy





# LC_Hash

> - **子串 、子区间**：要求连续
> - **子序列**：不要求连续
> - `{Unicode , cnt}` 可用 `HashMap<Character , Integer>` 存储
> - **字母异位词**：字符内容相同，顺序位置不同，重点在于提取其 `{ch , cnt}` 模式，且字符内容按字典序排序后都是相同的字符串
> - 桶排序：**建的桶是有序的**，桶内元素按照桶的顺序以正序或逆序的方式取出即可

- 对于包含大小写字母和数字的字符串直接开 `int[] pattern = new int[128];` ASCII 码值数组



## 字母异位词

> - [见上述滑动区间](#滑动区间)  
> - 模式 `pattern[]` 和 `windows[]` 的匹配
> - `LC_Hash` 的 `Solution_438 、76` 

- 固定的 `windows[]` 每滑动一次就要和 `pattern[]` 比较一次
- 非固定的 `[l , r]` 滑动过程中要保证始终为 `pattern[]` 的**严格子集**，且依然需要 `windows[]` 来记录 `[l , r]` 之间的字符模式
- 非固定的 `[l , r]` 可以为 `pattern[]` 的**非严格子集**，即可以只使用一个 `cnt` 来记录 `[l , r]` 中有多少个字符匹配 `pattern[]` 



## 路径前缀和

> - 边遍历，边计算
> - 前缀和是**包括当前元素在内**的，即 `prefixSum = sum([首元素 , ... , 当前元素])` 
> - 遍历到当前元素，优先计算完前缀和，再谈后续操作
> - 求的都是满足某种条件的**连续区间**的最长 `&` 个数

- 题型一：`{前缀和 , 下标} == {prefixSum , i}` 

  - 遍历过程中遇到之前存在相同的前缀和 `{prefixSum , j}` $\Rightarrow$ 则**连续区间段** `[j + 1 , i]` 的和为 `0` ，且该**区间段长度**为 `i - j` 
  - 注意一：需要**预先放入**一个 `{0 , -1}` $\Rightarrow$ 若从首元素到当前元素的前缀和恰好为 `0` ，则区间段长度为 `i - (-1)` 
  - 注意二：不能用 `i` 覆盖 `j` ，因为这种题型一般是求**最长连续区间段长度** $\Rightarrow$ `j` 越靠前越好
- 题型二：`{前缀和 , 个数} == {prefixSum , cnt}` 

  - 遍历过程中看是否存在 `{prefixSum - k , cnt}` 并**累加**其 `cnt` $\Rightarrow$ 这种题型一般是求**和为 `k` 的连续子区间的个数** 
  - 然后**更新**当前前缀和的个数 `{prefixSum , cnt + 1}` 
  - 注意一：需要**预先放入**一个 `{0 , 1}` $\Rightarrow$ 若从首元素到当前元素的前缀和恰好为 `k` ，则**累加**自身这条路径
  - 注意二：必须**先累加再更新**，避免所求连续子区间和为 `0` 的情况
  - 图例化：`root --> ... --> a --> A --> ... --> b --> B --> ... --> c` 
    - 前缀和 `root --> a` 为 `10`（此时有 `{10 , 1}`）
    - 前缀和 `root --> b` 为 `10`（此时有 `{10 , 2}`）
    - 前缀和 `root --> c` 为 `18`（此时可**累加两条**和 `k = 8` 的连续子区间：`A --> c` 和 `B --> c`）



## 坐标 Hash

> - 见 `Solution_74` 
> - 二维化一维：`[i][j] --> [i * col + j] == [x]` 
> - 一维化二维：`[x] --> [x / col][x % col]`（其中 `j ∈ [0 , col-1]` 不会影响 `/` 和 `%` 运算的）

```代码语言
matrix[i][j] == arr[i * col + j]
00 01 02 03  ==     0  1  2  3
10 11 12 13  ==     4  5  6  7
20 21 22 23  ==     8  9 10 11
```



## 求交集

> - **要求去重**用 `Set` 
> - **无需去重**用 `Map` 
> - **空间优化**：应该始终对**较短的**集合建立 `Set` 或 `Map` （[如下述建堆的空间优化](#堆)）



# LC_LCP

> - 暴力深搜 `&` 动态规划
> - 优先队列找最佳方案 $\Rightarrow$ **不断升级大根堆堆顶水缸的小水桶，看是否能得到更小的堆顶水缸蓄水操作次数** 



# LC_Linked

> - `head` 为**首节点** 
> - `dummy` 为**头节点**（在可能需要删除首节点 `head` 的情况下非常有用）
> - `tail` 为**有效尾节点（指针）** 
> - 规定：`head` 节点编号为 `1` 



## 快慢指针一

> - `slow = head`（依次指向节点编号 `1 、2 、3 、...`）
> - `fast = head.next`（依次指向节点编号 `2 、4 、6 、...`）（**偶数**）
> - `fast` 指向的<font style="color:red">节点编号</font>为 `slow` 的**两倍** 
> - `fast` 走过的<font style="color:red">节点个数</font>为 `slow` 的**两倍** 

- 初始化之前：只需判断 `head != null` 
- 循环条件使用： `while(fast != null && fast.next != null){...}` 
  - 如果链表节点个数是**奇数**的 $\Rightarrow$ 则结束时 `fast == null` 且 `slow` 指向**正中间** 
  - 如果链表节点个数是**偶数**的 $\Rightarrow$ 则结束时 `fast.next == null` 且 `slow` 指向**中间偏左**（即前半部分的尾节点）
- 可以用来**等分链表** 
- 用来**判断有环** 
  - 有环 $\Leftrightarrow$ 快慢指针**一定会相遇** 
  - 循环条件需改为 `while(slow != fast)` 且**内置** `if (fast == null || fast.next == null) {break;}`）
- 为什么快慢指针一定会相遇而不是快指针**跳跃 、超越过**慢指针呢？
  - 当 `slow` 入环时，假设此时 `fast` 距离它 `n` 个<font style="color:red">步长</font>，且 `n < L` （其中 `L` 为环的<font style="color:red">总步长</font> ）
  - 每走一次，`fast` 走两步即 `2` 个<font style="color:red">步长</font>，`slow` 走一步即 `1` 个<font style="color:red">步长</font>，二者的距离会缩减 `1` 个<font style="color:red">步长</font> 
  - 它们之间的距离会缩减为 `n-1 、 n-2 、... 、0` 个<font style="color:red">步长</font> $\Rightarrow$ 所以**证明了**一定会相遇
  - 这个过程中 `slow` 走了 `n` 次共 `n` 个<font style="color:red">步长</font> $\Rightarrow$ 且 `n < L` $\Rightarrow$ 所以也**证明了**用不了一圈 `fast` 就可以追上 `slow` 



## 快慢指针二

> - `slow = head.next`（依次指向节点编号 `2 、3 、4 、...`）
> - `slow = head.next.next`（依次指向节点编号 `3 、5 、7 、...`）（**奇数**）
> - `slow` 指向的<font style="color:red">节点编号</font>为 `fast` 的**奇数正中间**（[$\frac{1 + fast\ 编号}{2} = slow\ 编号$（见上述 `mid`）](#mid)）
> - `fast` 走过的<font style="color:red">步长边数</font>为 `slow` 的**两倍** 

- 初始化之前：需要判断 `head != null && head.next != null`  
- 循环条件使用： `while(fast != null && fast.next != null){...}` 
  - 如果链表节点个数是**奇数**的 $\Rightarrow$ 则结束时 `fast.next == null` 且 `slow` 指向**正中间** 
  - 如果链表节点个数是**偶数**的 $\Rightarrow$ 则结束时 `fast == null` 且 `slow` 指向**中间偏右**（即后半部分的首节点）
  - 其实就是**和上述恰好相反**，画个图就能理解这两种方式
- 用来**找环入口**（找环需按**步长**来算，而不是**节点数**来算）
  - 设 `head --> 环入口` 步长为：`a` 
  - 设 `环入口 --> 相遇点` 步长为：`b` 
  - 设 `相遇点 --> 环入口` 步长为：`c` 
  - 即环的总步长为：`L = b + c` 
  - 则相遇时 `slow` 走过的总步长为：`a + b` 
  - 则相遇时 `fast` 走过的总步长为：`a + b + kL == 2(a + b)`（其中 `1 <= k`）
  - 解得：`a == kL - b == (k-1)L + c` 
    - 然后让 `solw` 从 `head` 开始**一次一步** 
    - 然后让 `fast` 从相遇点开始**一次一步** 
    - 即会在**环入口处相遇** 



## <span id='链表的递归链接'>递归链接</span>

> - `当前层.next = 递归结果` 
> - `并且返回当前层` 
> - [见下述 `LC_Tree`](#LC_Tree)   



# LC_Offer_1





# LC_Offer_2

> - **邻接表**通常是 `Map<start , Set<ends>>` 格式
> - 两个 `Map` 的小操作：
> - `getOrDefault(key, defaultVal)`：存在 `key` 时返回对应的 `val` ，否则返回**指定的** `defaulVal` 
> - `putIfAbsent(key, val)`：如果 `key` 对应的 `val` 为 `null` 则更新为**指定的** `val` ，否则不更新
> - `Solution_207` 用 `List<List<Integer>>` 作为邻接表是因为其课程 `key == [0 , numCourses - 1]` 就可以作为 `List` 下标



# LC_Offer_3



# LC_SQ



## 堆

> - 不完全有序 `+` 可以重复

- **逻辑概念**为完全二叉树
  - 最大堆：子节点 `<=` 父节点（根最大）
  - 最小堆：子节点 `>=` 父节点（根最小）
- **物理存储**为数组
  - 从 `0` 开始编号 $\Rightarrow i\Rightarrow\left\{\begin{aligned}&父节点：\left\{\begin{aligned}&左孩子：i/2\\&右孩子：i/2 - 1\end{aligned}\right.\\&左孩子：2*i + 1\\&右孩子：2*i + 2\end{aligned}\right.$   $\Rightarrow$ 数组存储（最后一个非叶子节点为 `(n / 2) - 1`）
    - 其中 `n == max_i + 1` 即节点个数，**避免了**使用 `max_i / 2` 后还需**额外判断是否要** `-1` 的情况（[见向上取整技巧](#细节💥💥💥)）
  - 从 `1` 开始编号 $\Rightarrow i\Rightarrow\left\{\begin{aligned}&父节点：i/2\\&左孩子：2*i\\&右孩子：2*i + 1\end{aligned}\right.$   $\Rightarrow$ 数组存储（最后一个非叶子节点为 `max_i / 2`）
- 通常用于
  - 找前 `K` 大或前 `K` 小
  - 找第 `K` 大或第 `K` 小（**也可以用快排法**）
  - 典例如 `Solution_692 & Solution_215` 
  - **建堆的空间优化** 
    - 例如找第 `k` 大的元素 $\Rightarrow$ 需建立大小为 `k` 的小根堆
    - 若该 `k` 超过容量 `n` 一半大小，可以反过来找第 `n+1-k` 小的元素
    - 则只需建立大小为 `n+1-k` 的大根堆（`Solution_215` 评论）
- 操作
  - 添加元素：先添加到数组末尾 $\Rightarrow$ 然后一路**向上调整交换**（`O(logN)`）
  - 删除元素：
    - 删除数组首部元素 $\Rightarrow$ 用数组末尾**替换覆盖**，然后一路**向下调整交换**（`O(logN)`）
    - **堆排序**：依次取数组首部删除输出
    - 删除数组中间元素 $\Rightarrow$ 用数组末尾**替换覆盖**，然后判断**向上 `&` 向下调整交换**（`O(logN)`）
  - 堆化：对路径 `最后一个非叶子节点 => 向上 => 根节点` 上的每个节点执行**向下调整交换**（`O(N)`）
  - 查找：只能遍历数组，除了数组首部（**根节点**）为最大或最小，后面的元素**无特殊顺序** 



# LC_String







# LC_Tree

> - 见《MySQL》
> - **满**二叉树：**长满了**（节点个数为 `2^0 + 2^1 + ... + 2^{h-1} == 2^h - 1`）
> - **完全**二叉树：除了最低的一层，上面每一层都长满了，且最后一层的叶子节点**都集中在最左边** 
> - 完全二叉树的**任意子树**必然是完全二叉树或者满二叉树

## 遍历

> - 入栈入队**待访问** 
> - 出栈出队**访问之** 
> - 无论先序、中序、后序、层序遍历，每一层中**最先被访问**的节点一定是**最左边的节点** 

- 先序 $\Rightarrow$ **取巧法** $\Rightarrow$ 后序 $\Rightarrow\left\{\begin{aligned}&先序：根\ \ 左\ \ 右\\&交互：根\ \ 右\ \ 左\\&倒置：左\ \ 右\ \ 根\end{aligned}\right.$ （`Collections.reverse(List 、ArrayList 、LinkedList)`）
- 层序遍历：每访问一层的第一个节点**之前**，先得到该层的**节点个数 `len`**（即队列大小），因为此时队列内都是同一层的



## <span id='树的递归链接'>递归链接</span>

> - [见上述链表的递归链接](#链表的递归链接)



## 二叉搜索树  BST

> - 中序有序
> - 完全有序 `+` 不可重复
> - 左子树 < 根 < 右子树
> - 遍历过程中，要记录上一个遍历的节点，通常用一个**全局变量** `pre` ，每次处理完当前节点后，也要更新该 `pre` 节点



## 深度高度

> - 计算深度 `&` 高度必须是**叶子节点** 
> - 有时候带深度递归，是为了**判断**是否遇到了新的深度、新的层



## 最近公共祖先

> - 一个节点也可以是它自己的祖先
> - 在 BST 中需**自顶向下**搜索公共祖先，因为 BST 是**有方向性的** 
> - 在普通二叉树中需**自底向上后序遍历**搜索公共祖先



 $\Rightarrow$ 

 $\Rightarrow\left\{\begin{aligned}&\\&\\&\end{aligned}\right.$  





# 在线输入输出练习

> - [在线笔试常见输入输出练习](https://www.nowcoder.com/exam/test/65746788/detail?pid=27976983#question)   
> - [在线笔试常见输入输出答案](https://ac.nowcoder.com/acm/contest/5657#question)   
> - `int` 的范围是 $[-2\times10^9\ ,\ 2\times10^9]$（`20` 亿级别）（[见上述小细节](#小细节)）
> - 最后一题的范围是 $2\times10^{10}$ 百亿级别，需要使用 `long` 

```java
// A+B(1)
// 读取多组 {int , int}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // 读取 {int , int}
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

// A+B(2)
// 先读取一个 t
// 再读取 t 组 {int , int}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取 t
        int t = in.nextInt();
        while (t > 0) {
            // 读取 {int , int}
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
            t--;
        }
    }
}

// A+B(3)
// 读取多组 {int , int}
// 遇到 {0 , 0} 停止
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // 读取 {int , int}
            int a = in.nextInt();
            int b = in.nextInt();
            // 遇到 {0 , 0} 停止
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }
}

// A+B(4)
// 读取多行
// 每行开头为 n ，且求和该行接下来的 n 个数 {a , b , ...}
// 遇到 n 为 0 结束
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // 读取行首 n
            int n = in.nextInt();
            // 遇到 n 为 0 结束
            if (n == 0) {
                break;
            }
            // 求和 n 个数
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}

// A+B(5)
// 先读取一个 t 
// 接下来读取 t 行
// 每行开头为 n ，且求和该行接下来的 n 个数 {a , b , ...}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取 t
        int t = in.nextInt();
        while (t > 0) {
            // 读取行首 n
            int n = in.nextInt();
            // 求和 n 个数
            int sum = 0;
            for (int i = 0; i < n; i ++) {
                sum = sum + in.nextInt();
            }
            System.out.println(sum);
            t--;
        }
    }
}

// A+B(6)
// 就比 A+B(4) 少了一个判断 n 为 0 结束
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // 读取行首 n
            int n = in.nextInt();
            // 求和 n 个数
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}

// A+B(7)
// 读取多行，求和每行的所有数字
// 每行开头不再有 n ，需要自行分隔，详见 Beginning.java 的 splitRules() 方法
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 读取一行，按 " " 分隔（要求输入严格，不能有前缀空白）
            String[] nums = in.nextLine().split(" ");
            int sum = 0;
            for (int i = 0; i < nums.length; i ++) {
                sum = sum + Integer.valueOf(nums[i]);
            }
            System.out.println(sum);
        }
    }
}

// 字符串排序(1)
// 第一行读取一个 n
// 第二行读取 n 个字符串排序后输出
import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 用 nextLint() 可以消除第一行末尾的换行符，否则下一个 nextLint() 读取到的就会是空串!!!!!!!!!!
        // 即：永远不要在 nextXXX() 之后使用一个 nextLine()
        // 要么一直用 nextXXX()
        // 要么一直用 nextLine()
        int n = Integer.parseInt(in.nextLine());
        String[] arr = in.nextLine().split(" ");
        Arrays.sort(arr);
        for (int i = 0; i < n; i ++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }
}

// 字符串排序(2)
// 读取多行
// 每行用空格 " " 隔开多个字符串，将字符串排序后输出
import java.util.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        // 依旧用 nextLine() 读取
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            Arrays.sort(strs);
            // join 函数
            String ans = String.join(" ", strs);
            System.out.println(ans);
        }
    }
}


// 字符串排序(3)
// 读取多行
// 每行用逗号 "," 隔开多个字符串，将字符串排序后输出（即将字符串排序(2)的全部 " " -> "," 即可）
import java.util.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        // 依旧用 nextLine() 读取
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String[] strs = str.split(",");
            Arrays.sort(strs);
            // join 函数
            String ans = String.join(",", strs);
            System.out.println(ans);
        }
    }
}

// 自测本地通过提交为 0
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLong()){
            Long a = in.nextLong();
            Long b = in.nextLong();
            System.out.println(a + b);
        }
    }
}
```



# 设计模式

> - 根据**目的**划分 $\Rightarrow\left\{\begin{aligned}&创建型模式\\&结构型模式\\&行为型模式\end{aligned}\right.$  
> - 按照**范围**划分 $\Rightarrow\left\{\begin{aligned}&类模式\\&对象模式\end{aligned}\right.$  

# UML 类图

> - 包名：全部小写
> - 类名：每个单词的首字母都大写
> - 方法名 `&` 属性名：第一个单词全小写，后面的单词首字母都大写
> - 成员变量：`可见性 变量名 : 数据类型 = 默认值` 
> - 成员方法：`可见性 方法名(参数列表) : 返回值类型`（构造方法无返回值类型）

- 可见性
  - `+ == public` 
  - `- == private` 
  - `# == protected` 
  - `* == default` 
- 继承关系 `+` 实现关系
- 关联关系：一个类的对象**作为**另一个类的**成员变量** 
  - 单向关联 `+` 双向关联 `+` 自关联 `+` 多重关联：$\longrightarrow$ 
  - 聚合 $\Rightarrow$ **相互独立**的整体与部分 $\Rightarrow\left\{\begin{aligned}&构造注入\\&Setter\ 注入\\&方法参数注入\end{aligned}\right.$ ：◇$\longrightarrow$ 
  - 组合 $\Rightarrow$ **同生共死**的整体与部分 $\Rightarrow$ 构造方法中直接实例化：◆$\longrightarrow$ 
- 依赖关系：一个类的方法**使用**另一个类的对象**作为参数** $\Rightarrow\left\{\begin{aligned}&方法参数注入\\&方法中创建另一个类的局部变量\\&方法中调用另一个类的静态方法\end{aligned}\right.$   



# UML 类图箭头

<div align="center" style="display:flex">
		<img src="/imgs/UML 类图.png" width="250px" height="280px" />
		<img src="/imgs/UML 类图.png" width="250px" height="280px" />
		<img src="/imgs/UML 类图.png" width="250px" height="280px" />
</div>



# 原则

## 单一职责原则

> - **高内聚，低耦合** 
> - 一个对象应该只包含**单一的职责**，并且该职责被**完整地封装**在一个类中
> - 多职责耦合 $\Rightarrow$ **根株牵连** $\Rightarrow$ 牵一发而动全身 $\Rightarrow$ **职责分离** $\Rightarrow$ 控制**类的粒度**大小
> - 如果多个职责总是**同时发生改变**，则可以将它们封装在同一个类中

## 开闭原则

> - 对扩展**开放**，对修改**关闭** $\Rightarrow$ 尽量在不修改的情况下进行扩展 $\Rightarrow$ 定义一个**稳定的抽象层**是关键

## 里氏代换原则

> - 所有引用基类的地方必须能够**透明地使用**其子类
> - 将一个基类对象**替换成**子类对象，程序不会产生任何错误或异常，但反过来不一定成立

## 依赖倒转原则

> - 用基类**声明定义**，用子类**实际运行** 
> - 子类尽量不要给出**多余的方法**，否则**无法调用** 
> - 针对接口编程，不要针对实现编程
> - 三种依赖注入 $\Rightarrow\left\{\begin{aligned}&构造注入\\&Setter\ 注入\\&方法参数注入\end{aligned}\right.\Leftarrow$ 具体数据类型的类名存储在**配置文件**（修改时只需修改配置文件，无需修改源代码）

## 接口隔离原则

> - 大接口 $\Rightarrow$ 细分 $\Rightarrow$ **宽窄不同**的**定制化**接口 $\Rightarrow$ 控制**接口的粒度**大小

## 合成复用原则

> - 多用**关联（`Has A`**），少用**继承（`Is A`）** 
> - 降低类与类之间的耦合
> - 继承破坏封装性 $\Rightarrow\left\{\begin{aligned}&基类的实现暴露给了子类（白箱复用）\\&基类的实现发生变化\Rightarrow子类的实现也得改变\\&继承是静态的，不能在运行时动态变化，缺乏灵活性\end{aligned}\right.$  
> - 黑箱复用：一个对象调用另一个对象的功能，且能动态注入、动态调用、动态运行

## 迪米特法则

> - 类的耦合度越低，就越有利于复用 $\Rightarrow\left\{\begin{aligned}&尽量降低成员变量和成员函数的访问权限\\&且只要有可能\Rightarrow就应当设计成不变类\\&对其他对象的引用应当降到最低\end{aligned}\right.$   
> - 限制软件实体之间通信交互的**宽度和深度** $\Rightarrow\left\{\begin{aligned}&只和亲密朋友说话\\&或者中间人\ Mediator\ 传话\\&不要和陌生人说话\end{aligned}\right.$   $\Rightarrow$ 降低系统的耦合度



# 创建型

> - 对象的**创建**和对象的**使用**分离
> - 隐藏实例的创建细节
> - 防止实例化代码到处都是
> - 一个类可能有多个构造函数，可以为每个构造函数提供一个参数列表对应 `&` 名称辨识度更高的工厂方法



## 简单工厂模式

> - 工厂类 `Factory` 提供一个**静态工厂方法** $\Rightarrow$ 返回类型为抽象产品类型 `Product` 
> - 工厂类 `Factory` 统一负责所有具体产品的创建 $\Rightarrow$ 根据**传入的参数**返回不同的具体产品类 `ConcreteProduct` 的实例对象
> - 进一步简化：将静态工厂方法移至抽象产品类 `Product` 中，直接免去工厂类 `Factory` 
> - 又称为静态工厂模式

- 缺点 $\Rightarrow\left\{\begin{aligned}&工厂类集中了所有具体产品类的创建逻辑，职责过重\\&一旦增加新的具体产品，就必须得修改工厂类的静态工厂方法，一定程度上违反了开闭原则\end{aligned}\right.$  



## 工厂方法模式

> - 抽象工厂类 `Factory` $\Rightarrow$ 具体工厂类 `ConcreteFactory` $\Rightarrow$ 创建具体产品类 `ConcreteProduct` 
> - 工厂等级结构 `==` 产品等级结构
> - 具体工厂和具体产品**一一对应** 
> - 又称为虚拟构造器模式 `&` 多态工厂模式

- 缺点：添加新的产品类，需添加新的工厂类，类的个数**成对增加** 



## 抽象工厂模式

> - 纵向：产品等级结构
> - 横向：产品族（由同一个工厂生产的 、位于不同产品等级结构中的 、相关的 、相互依赖的 、一组产品）
> - 工厂方法模式针对的是**一个**产品等级结构，一个具体工厂 $\Rightarrow$ 创建 $\Rightarrow$ **一个**具体产品
> - 抽象工厂模式针对的是**多个**产品等级结构，一个具体工厂 $\Rightarrow$ 创建 $\Rightarrow$ **一族**具体产品
> - 抽象工厂中：声明一组用于创建一族产品的方法，每个方法对应产品族中的一个产品
> - 典型应用例如：主题，每个主题有图标 、按钮 、颜色 、背景等等，可视为一个产品族，一个工厂创建一种主题
> - 适用场景：产品等级结构**稳定** `+` 属于同一产品族中的产品将在一起使用，这一约束必须在系统的设计中体现出来
> - 又称为工具 `Kit` 模式

- 缺点：开闭原则的倾斜性：增加新的产品族很方便，增加一个工厂即可，但增加新的产品等级结构很麻烦



## 建造者模式

> - 一步一步创建一个复杂产品
> - 抽象构建者 `Builder` $\Rightarrow$ 为创建一个复杂产品的**各个部件**指定抽象接口 `buildA() 、buildB() 、...` 以及**返回产品** `getRes()` 
> - 抽象构建者**聚合**一个复杂产品对象，用于在 `getRes()` 中返回
> - 不同的具体构建者 `ConcreteBuilder` $\Rightarrow$ 不同的复杂产品
> - 指挥者 `Director` **聚合**一个构建者 $\Rightarrow$ 负责安排复杂产品的**建造次序 `&` 装配过程**，即调用 `buildA() 、buildB() 、...` 的次序
> - 客户端 $\Leftrightarrow$ 指挥者（**隔离作用**） $\Leftrightarrow$ 构建者
> - 对象的创建过程（指挥者）独立于对象的创建（构建者）：使得相同的创建过程可以创建不同的产品
> - 也可以省略指挥者，将**建造次序 `&` 装配过程**直接写在抽象构建者中，例如 `getRes()` 中
> - 可以在抽象构建者中增加一系列**钩子方法** `Hook Method` $\Rightarrow$ 控制是否对某个 `buildX()` 进行调用执行
> - 钩子方法一般为 `boolean isXXX()` 
> - 抽象构建者中提供钩子方法的默认实现，具体构建者中进行重写覆盖
> - 在指挥者的创建过程中调用这些钩子方法以更加精细地控制产品的创建过程

- 缺点：创建的产品一般必须具有较多的共同点，组成部分应该相似，限制了产品之间的差异性



## 原型模式

> - 通过**复制克隆**原型对象创建新的对象
> - 可以定义一个**原型管理器** `Prototype Manager` 存储多个原型对象，并提供复制克隆原型的工厂方法（通常将原型管理器设计为**单例类**）
> - 复制 `&` 粘贴就是原型模式的典型应用



## 单例模式

> - 一个类只能有一个实例
> - 自行**创建**它的唯一实例（`private` 的构造函数）
> - 自行**保存**它的唯一实例（`private static` 的自身对象成员变量）
> - 自行向整个系统**提供**它的唯一实例（`public static getInstance()` 的工厂方法）
> - 提供了对唯一实例的受控访问，可以节约系统资源
> - 可以扩展为**多例类**：自行提供指定数目的实例对象的类
> - 饿汉式 `&` 懒汉式 $\Rightarrow$ 静态内部类

- 缺点 $\Rightarrow\left\{\begin{aligned}&没有抽象层\\&单例类职责过重\end{aligned}\right.$  



# 结构型

> - 类结构型模式：类与类的组合，通常是**继承关系**和**实现关系** 
> - 对象结构型模式：类与对象的组合，通过**关联关系**在一个类中定义另一个类的实例对象



## 适配器模式

> - 生活用电电压 `220V` $\Rightarrow$ 电源适配器 $\Rightarrow$ 笔记本 、手机等设备电压
> - 将一个类的接口和另一个类的接口匹配起来，让那些接口不兼容的类可以一起工作
> - 例如购买了一些第三方类库或控件，需要与当前系统的需求进行接口适配
> - **适配器** `Adapter` 对**适配者** `Adaptee` 和**目标类** `Target` 进行适配，且无需修改适配者 `Adaptee` 和目标类 `Target` 的源代码
> - 将适配者和目标类解耦，增加了类的透明性
> - 提高了适配者的复用性，一个适配者可以被适配给多个不同的目标类，当然也可以把多个适配者适配给同一个目标类
> - 常用的对象结构型适配器：适配器 `Adapter` 维持一个适配者 `Adaptee` 的关联引用，且**继承目标类** `Target` 
> - 缺省适配器模式：接口 $\Rightarrow$ 抽象类（对抽象方法提供默认实现） $\Rightarrow$ 具体类（**选择性地实现**抽象方法或**重写覆盖**默认实现）
> - 缺省适配器模式例如：`ArrayList  extends  AbstractList  implements  List` 
> - 双向适配器模式：适配器 `Adapter` 既维持一个适配者 `Adaptee` 的关联引用又维持一个目标类 `Target` 的关联引用
> - 又称为包装器 `Wrapper` 模式



## 桥接模式

> - 识别出一个类所具有的两个独立变化的维度 $\Rightarrow$ 将这两个维度设计成两个独立的继承等级结构（**解耦**）$\Rightarrow$ 使得二者能够灵活地独立变化
> - 并在它们的抽象层建立**抽象关联**（**抽象耦合**） $\Rightarrow$ 该关联关系就是一条连接着两个独立继承等级结构的**桥** 
> - 以便**任意组合**两个继承等级结构中的子类
> - 极大地减少了子类的个数（若两个维度耦合在一起，则形成的继承等级结构将非常复杂且子类繁多，`3 * 12`）
> - 又称为柄体 `Handle and Body` 模式

- 缺点：增加了系统的理解与设计难度



## 组合模式

> - 统一地对待**单个对象**和**组合对象** 
> - 典型应用例如 `File` 既可以表示文件（单个对象），又可以表示文件夹（组合对象）
> - 通常需要**递归访问**组合对象
> - 为树形结构的面向对象实现提供了一种灵活的解决方案，通过单个对象和组合对象的递归组合可以形成**复杂的树形结构** 
> - 透明组合模式：单一对象和组合对象所提供的方法是一致的，**不安全的**，为单一对象提供 `add() 、remove() 、getChild()` 没有意义
> - 安全组合模式：单一对象和组合对象方法有别，**不够透明**，客户端不能完全针对抽象编程，必须有区别地对待单一对象和组合对象
> - 又称为部分-整体 `Part-Whole` 模式



## 装饰模式

> - 给一个对象**动态地增加**一些额外的功能职责，比使用继承关系定义子类更加灵活
> - 抽象装饰器类 `Decorator` 和被装饰的具体构件 `ConcreteComponent` 通常具有**共同的父类**抽象构件 `Component` 
> - 以便客户端可以以一致的方式处理未被装饰的对象以及装饰之后的对象，实现客户端的透明操作
> - 且可以多次装饰，多次扩展功能职责
> - 透明装饰模式：装饰器类定义的新方法在抽象构建 `Component` 定义的业务方法中调用，客户端**完全面向抽象编程** 
> - 半透明装饰模式：装饰器类定义的新方法有时需要单独调用，客户端**无法一致地对待**未被装饰的对象以及装饰之后的对象
> - 半透明装饰模式要求客户端使用具体装饰类 `ConcreteDecorator` 定义对象，其**最大的缺点**是不能对同一个对象进行多次装饰

- 缺点 $\Rightarrow\left\{\begin{aligned}&产生很多小对象，它们之间仅是相互连接的方式不同，而不是类或者属性值不同，将占用更多的系统资源，影响系统性能\\&对于多次装饰的对象，调式排错比较困难，需要逐级排查\end{aligned}\right.$  



## 外观模式

> - 客户端 $\Leftrightarrow$ 服务员（外观类 `Facade`） $\Leftrightarrow$ 多个业务类（子系统）
> - 外观类 `Facade` 为子系统中的一组接口提供了一个统一方便的入口，使得子系统更加容易使用
> - 客户端只需要与外观类打交道，而不需要与子系统中的多个业务类打交道，降低了系统的耦合度
> - 是[迪米特法则](#迪米特法则)的一种具体实现
> - 在外观类 `Facade` 中需要维护对子系统对象的关联引用
> - 增加或删除子系统需要修改外观类，一定程度上不满足开闭原则 $\Rightarrow$ 引入**抽象外观类** 
> - 对于新的业务需求，增加一个新的具体外观类，关联引用新的子系统对象，客户端也可以针对抽象外观类进行编程
> - 又称为门面模式



## 享元模式

> - 在享元池 `Flyweight Pool` 中存储一些可供共享的实例对象 $\Rightarrow$ 高效地支持大量**细粒度对象**的重用
> - **内部状态**：不会随环境变化而改变的状态，内部状态是可以共享的，通常保存在享元对象内部
> - **外部状态**：随环境变化而改变的状态，不可共享，通常保存在客户端，客户端在使用时可以将外部状态**注入到**享元对象中
> - 抽象享元类 `Flyweight` 声明了具体享元类 `ConcreteFlyweight` 的公共方法：**提供**内部状态的方法 `+` **设置**外部状态的方法
> - 具体享元类 `ConcreteFlyweight` 为内部状态**提供了存储空间** 
> - 享元工厂 `FlyweightFactory` 针对抽象享元类 `Flyweight` 编程，存储享元池，通常是 `HashMap` 即键值对的集合
> - 通常可以将具体享元类 `+` 享元工厂都设计为**单例类** 
> - 又称为轻量级模式



## 代理模式

> - 给某个目标对象提供一个代理或占位符，并由代理对象来控制对目标对象的访问
> - 客户端 $\Leftrightarrow$ 代理 `&` 中介（去掉客户端不能看到的内容 `+` 增添客户端需要的额外服务）$\Leftrightarrow$ 目标对象
> - **代理主题角色** `Proxy` 和**真实主题角色** `RealSubject` 有共同的父类**抽象主题角色** `Subject` 
> - 方便客户端针对抽象主题角色编程，无需区分代理主题角色和真实主题角色
> - 代理主题角色需维护一个对真实主题角色的**关联引用**，可以调用真实主题角色的业务方法，也可以进行**功能的扩展 `&` 约束** 



# 行为型

> - 类行为模式：使用继承关系分配行为，通过多态等方式来分配父类与子类的职责
> - 对象行为模式：使用关联关系分配行为



## 职责链模式

> - 将多个对象连接成一条链，**沿着这条链传递请求**，让多个对象都有机会处理请求
> - 抽象处理者 `Handler` 维护一个自身的关联引用 `Handler successor`（下一个处理者，一般通过 `Setter` 注入，便于**自定义职责链**）
> - 纯的职责链模式：一个具体处理者要么**承担全部责任**，要么将责任完全推给下一个处理者，且请求必须被某一个处理者处理掉
> - 不纯的职责链模式：一个具体处理者可以**仅处理部分责任**，然后推给下一个处理者继续处理，且请求可以最终不被任何处理者处理掉

- 缺点 $\Rightarrow\left\{\begin{aligned}&一个请求可能因职责链没有被正确配置而得不到处理\\&进行代码调试不太方便\end{aligned}\right.$  



## 命令模式

> - 相同的开关 $\Rightarrow$ 不同的电线 $\Rightarrow$ 控制不同的电器
> - 将一个请求 `&` 命令封装为一个对象
> - 请求发送者 `Invoker` $\Rightarrow$ 请求 `&` 命令（抽象命令类 `Command` 和具体命令类 `ConcreteCommand`）$\Rightarrow$ 请求接收者 `Receiver` 
> - 将请求发送者和接收者完全解耦，请求发送者只需要知道如何发送请求，不必知道如何完成请求
> - 请求发送者 `Invoker` **聚合**一个抽象命令类 `Command` ，构造注入或 `Setter` 注入，可以对同一个请求发送者注入不同的命令类
> - 具体命令类 `ConcreteCommand` **组合**一个请求接收者 `Receiver` ，构造方法中直接实例化，一个具体命令类对应一个请求接收者
> - **命令队列**：`CommandQueue` 存储多个 `Command` ，`Invoker` 聚合一个 `CommandQueue` ，其实就是**批处理** 

- 缺点：可能会导致系统中出现大量的具体命令类，因为针对每一个请求接收者都需要设计一个具体命令类



## 解释器模式



## 迭代器模式

> - 遥控器（迭代器） $\Leftrightarrow$ 电视机（数据集合）
> - 将遍历数据的行为从数据集合中分离出来，封装在迭代器中
> - 避免暴露数据集合的内部表示
> - 在同一个数据集合上可以定义多个迭代器，表示多种遍历方式
> - 可以将迭代器设计为数据集合的**内部类** 

- 缺点 $\Rightarrow\left\{\begin{aligned}&增加新的数据集合需增加新的迭代器，类的个数成对增加，增加了系统的复杂性\\&抽象迭代器设计难度较大，需充分考虑到系统将来的扩展\end{aligned}\right.$  



## 中介者模式

> - 网状系统（多对多关系） $\Rightarrow$ 星形系统（一对多关系）
> - 将对象之间的交互封装为一个对象，可以使对象之间的关系数量急剧减少
> - 是[迪米特法则](#迪米特法则)的一种具体实现
> - 抽象中介者 `Mediator` $\Rightarrow$ 具体中介者 `ConcreteMediator`（维持了需要交互通信的**具体**同事类对象的关联引用）
> - 抽象同事类 `Colleague`（维持了一个**抽象**中介者的关联引用）$\Rightarrow$ 具体同事类 `ConcreteColleague` 
> - 抽象同事类 `Colleague` 中一般声明有一个**依赖方法** `Depend-Method` ，用于调用中介者的方法，即与中介者通信
> - 具体同事类在需要与其他同事类通信时，调用该继承的依赖方法**先与中介者通信**，通过中介者完成与其他同事类的通信
> - 具体同事类可以定义各自的业务方法，具体中介者中封装了具体同事类对象的交互，可以调用具体同事类的各自的业务方法
> - 但客户端就没法针对抽象同事类编程了

- 缺点：具体中介者中包含了大量同事类之间的交互细节，职责过重



## 备忘录模式

> - 后悔药
> - 提供了一种状态恢复的实现机制
> - 保存系统的历史状态，让系统能够恢复到某一特定的历史状态
> - 在不破坏封装的前提下**捕获**一个对象的内部状态，并在该对象之外**保存**这个状态
> - 原发器 `Originator`：需要保存内部状态以供恢复的类
> - 备忘录 `Memento`：存储原发器的内部状态，参考原发器的设计确定备忘录中的属性，除了原发器和负责人，**不能供其他类使用** 
> - 负责人 `Caretaker`：仅负责保存备忘录，不能修改备忘录，也无需知道备忘录的实现细节
> - 可以将备忘录 `Memento` 和原发器 `Originator` 定义在同一个包中，且备忘录为**仅包内可见**，以实现封装
> - 也可以将备忘录设计为原发器的**内部类**，以实现封装

- 缺点：需要消耗系统资源保存历史状态



## 观察者模式

> - 一个对象发生改变时将**自动通知**其他对象，其他对象将作出相应的反应
> - 提供了**一对多广播通信**系统的设计方案，典型例子是**红绿灯** 
> - 抽象目标类 `Subject` 是**被观察的对象**，定义了一个观察者集合，提供方法增加 `&` 删除观察者，且需定义一个 `notify()` 通知方法
> - 具体目标类 `ConcreteSubject` 包含有**经常发生改变**的数据，当它的状态改变时将通知各个观察者
> - 抽象观察者 `Observer` 
> - 具体观察者 `ConcreteObserver` 通常会维护一个具体目标类的关联引用
> - 可以调用具体目标类的 `attach() & detach()` 方法将自己添加到目标类的观察者集合中，或将自己从观察者集合中删除
> - 还可以获取具体目标类的一些内部状态信息，用于自身的更新响应
> - 但需注意：由于在具体层建立关联关系，系统的扩展性将收到一定影响
> - 流行的 `MVC (Model-View-Controller)` 构架：实现数据的**逻辑层**和数据的**表示层**分离
> - 又称为发布-订阅 `Publish-Subscribe` 模式 、源-监听器 `Source-Listener` 模式 、模型-视图 `Model-View` 模式



## 状态模式

> - 水 $\Rightarrow$ 气体状态 `&` 液体状态 `&` 固体状态
> - 将一个对象的状态从该对象中分离出来，封装到专门的**状态类**中，使得对象的状态可以灵活的变化，且状态变化时 $\Rightarrow$ 行为也将发生改变
> - 环境类 `Context`：拥有多种状态的类，维护一个抽象状态类 `State` 的关联引用，表示当前状态
> - 抽象状态类 `State` $\Rightarrow$ 具体状态类 `ConcreteState` 
> - 状态的改变方式一：环境类 `Context` 提供 `Setter` 可以注入不同的状态
> - 状态的改变方式二：环境类 `Context` 提供 `changeState(其他属性值){...}` 通过自身内部的某些属性值判断是否需要进行状态转换
> - 状态的改变方式三：在具体状态类 `ConcreteState` 的业务方法中负责判断状态是否需要进行转换，此时则需要建立**双向关联**关系
> - 若多个环境类 `Context` 的对象需要**共享同一个或多个状态**，需要将这些状态对象定义为环境类的**静态 `static` 成员对象** 

- 缺点：对开闭原则的支持并不太好，增加新的状态类，需要修改那些负责状态转换的源代码



## 策略模式

> - 抽象策略类 `Strategy` $\Rightarrow$ 具体策略类 `ConcreteStrategy` $\Rightarrow$ 封装不同的策略 `&` 算法
> - 使用者可以维护一个抽象策略类的关联引用，并提供 `Setter` 方法以注入不同的具体策略类
> - 算法的使用和算法本身解耦



## 模板方法模式

> - **步骤次序**是固定的 `==` **算法框架**是固定的
> - 基于继承的代码复用
> - 父类提供**模板方法 `Template Method`**定义步骤次序 `&` 算法框架 $\Rightarrow$ 每个或某些步骤的具体内容**延迟到子类中实现** 
> - 可以将父类中的模板方法定义为 `final` 的，表明不能被子类重写覆盖
> - 父类中可以定义一些钩子方法 `boolean isXXX()` ，用于控制某些步骤方法的**调用执行与否** 
> - 子类对这些钩子方法进行重写覆盖，可以**更精细地反向控制**父类的模板方法中某些步骤方法的调用执行与否



## 访问者模式

> - 医生开具处方单 $\Rightarrow$ 划价人员访问并计算总价 $\Rightarrow$ 药房人员访问并准备药物 $\Rightarrow$ 不同人员访问有不同的操作
> - 在不改变被访问的元素的类定义的情况下，定义作用于这些元素的新操作
> - 抽象元素 `Element`（声明了 `accept(Visitor)` 方法用于接受抽象访问者的访问操作） $\Rightarrow$ 具体元素 `ConcreteElement` 
> - 对象结构 `ObjectStructure`：存储元素集合
> - 抽象访问者 `Visitor`：需要为**每一个具体元素**声明一个对应的访问操作（<font style="color:red">两种命名方式</font>）
> - 一个访问者可以用不同的方式访问不同的元素
> - 一种元素可以接受不同的访问者以不同的方式访问
> - 增加新的访问者：无需修改任何源代码，只需在新的访问者中实现对每一个具体元素的访问操作即可
> - 增加新的元素：麻烦大了，需要在抽象访问者和具体访问者中增添相应的访问方法

- 缺点：[类似于上述抽象工厂模式的开闭原则的倾斜性](#抽象工厂模式)，且破坏了封装性，元素需暴露自己的内部状态给访问者，以便其进行访问操作



# 技巧

> - 接口中的方法太多，实现接口就会很复杂 $\Rightarrow$ 使用抽象类，提供一些默认实现
> - 静态方法只能被继承，不能被重写，且静态方法是**静态绑定**的
> - [定义自身类型的成员变量，是否会无限套娃一](https://blog.csdn.net/m0_62190011/article/details/126190955?spm=1001.2101.3001.6650.4&utm_medium=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-4-126190955-blog-51579426.pc_relevant_recovery_v2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-4-126190955-blog-51579426.pc_relevant_recovery_v2&utm_relevant_index=5)（[见上述单例模式](#单例模式)）
> - [定义自身类型的成员变量，是否会无限套娃二](https://www.bbsmax.com/A/ZOJPEYbe5v/)   



# 符号

> |  😏   |  1️⃣   |  🆘   |
> | :--: | :--: | :--: |
> |  😛   |  2️⃣   |  🔞   |
> |  💥   |  3️⃣   |  💯   |
> |  💡   |  4️⃣   |  🔴   |
> |  💵   |  5️⃣   |  🔵   |
> |  💎   |  ⏬   |  ✅   |
> |  🚀   |  ⏫   |      |



# 无倦

> - 2023 年

> ```
> // 2.23
> // LC_DP   【01 背包系列】【完全背包系列】
> // LC_Tree 【遍历顺序系列】
> // LC_50   【Codec 二叉树的序列化和反序列化】
> // LC_Back 【组合系列】【排列系列】
> 
> // 2.24
> // LC_DBFS 【记忆化深搜最优系列】【最短距离、广搜、层思想系列】【岛屿系列】【拓扑排序系列】
> // LC_HASH 【{X , cnt} 系列】【前缀和系列】
> 
> // 2.25
> // LC_Array 【二分法系列】【双指针系列】
> 
> // 2.26
> // LC_Array  【有效尾指针系列】【找元素系列】【排序系列】
> // LC_Linked 【链表归并系列】【搜索并处理系列】
> // LC_Bit    【模拟加法系列】
> 
> // 2.27
> // LC_Linked  【快慢指针系列】【其他】
> // LC_LCP
> // LC_Offer_2
> // LC_Hash    【交集双指针系列】
> // LC_String  【模拟系列】
> 
> // 2.28
> //LC_String 【滑动窗口系列】
> //LC_Bit    【快速幂系列】【Integer 源码系列】【十进制系列】
> 
> // 3.1
> //LC_String 【其他】【反转字符串系列】
> //LC_Bit    【字符串 --> 二进制系列】
> //LC_Hash   【数字和系列】
> 
> //3.2
> //LC_Tree 【二叉搜索树 BST 系列】【两棵树系列】【其他】【层序遍历系列】
> //LC_Tree 【高度、深度系列】【最近公共祖先系列】【路径、路径和系列】
> 
> //3.4
> //LC_DP 【回文系列】
> 
> //3.5
> //LC_DP 【路径条数系列】【打家劫舍系列】【连续子数组系列】
> 
> //3.9
> //LC_DP 【完全分割系列】
> 
> 
> 
> 
> LC_DP 、LC_Greedy
> LC_Offer_1 、LC_Offer_3
> LC_SQ
> ```



# 遗留难题

> - `LC_Offer` **需特别注明** 

> ```
> //在 Idea 中搜索：（难题）（遗留问题）
> 双向 bfs：127
> 中位数：4
> 摆动排序：324
> 深搜广搜：212 + 698 + 756
> 滑动区间：395
> 
> 
> //在 Idea 中搜索：（仅遗留问题）
> 54 、59 、48
> ```





# 遗留方法

> - `LC_DP` 的 `Solution_70.java` 的**方法三**：矩阵快速幂计算斐波那契数列
> - `LC_50` 的`Codec.java` 的**方法二**：迭代的方式序列化和反序列化二叉树
> - `LC_Back` 的 `Solution_491.java` 的**方法二**：递增子序列同层去重
> - `LC_DBFS` 的 `Solution_542` 的**方法二**：动态规划计算层数
> - `LC_Bit` 的 `Solution_371` 的**方法二 、三**：不考虑进位的加法过程
> - `LC_Linked` 的 `Solution_138` 的**方法二**：递归深拷贝链表



