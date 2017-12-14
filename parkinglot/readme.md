[TOC]
# requirements	
## 1.ParkingLot出现

### tasks
1. 停车
	1. 停车场有空位，可以停车
	2. 停车场没有空位，停车失败
3. 取车
	4. 车停在停车场，可以取车
	5. 车不在停车场，取车失败

## 2.原有需求不变，ParkingBoy出现

### tasks
1. 停车
	1. 该 parking boy 管理的停车场，有空位，可以停车
	2. 该 parking boy 管理的停车场，都有空位，往以第一个有空位的停车场停车
	3. 该 parking boy 管理的停车场，都没有空位，不能停车
2. 取车
	3. 车停在当前 parking boy 管理的某个停车场，可以取车
	4. 车不停在当前 parking boy 管理的停车场，不可以取车
 
## 3.原有需求不变, SmartParkingBoy出现
### tasks
1. 停车
	2. 该 parking boy 管理的停车场，空位数不同时，往空位多的停车场停车
	3. 该 parking boy 管理的停车场，空位数相同时，可以停车成功
	4. 该 parking boy 管理的停车场，没有空位时，停车失败

## 4.原有需求不变（可以重构），SuperParkingBoy出现
1. 停车
	2. 该 parking boy 管理的停车场，空车率不同时，往空位多的停车场停车
	3. 该 parking boy 管理的停车场，空车率相同时，可以停车成功
	4. 该 parking boy 管理的停车场，没有空位时，停车失败

## 5.原有需求不变，ParkingManager出现
1. parking manager 可以让 parkingBoy 停车，如果 parking boy 有空位，停车成功
1. parking manager 可以让 parkingBoy 停车，如果 parking boy 没空位，停车失败
1. parking manager 可以往 parking lot 停车，如果 parking lot 有空位，停车成功
1. parking manager 可以往 parking lot 停车，如果 parking lot 没空位，停车成功
2. 车停在 parking manager 管理的停车场，可以取车成功
2. 车没停在 parking manager 管理的停车场，取车失败

## 6.原有需求不变，ParkingManager的Report功能出现

*	Manager列出ParkingBoy所管理的车和自己管理ParkingLot的车，并且Manager也可以管理Manager

ParkingBoy列出所管理的ParkingLot中的车


# notes

*	引入ParkingLot，可以停车取车 （20分钟，tasking coding）
	*	首先做的一步是保证需求理解一致，而非实现功能 （审查代码）（parking boy需求出现，要求switch）
	*	switch pair，使用观察者和领航者模式，领航者为没有被switch的人，负责写测试，观察者来实现测试 （审查代码）
	*	在没有重构工具帮助的时候，小步修改，先加再删
	*	使用IDE帮助重构代码，对于安全的操作可以直接修改
	*	保证ParkingLot Boy的需求做完
	*	没有task list就不开始做story
	*	task list不清楚时，应该把需求弄清楚
*	开始SmartBoy的需求 （审查代码）（重构）
	*	完成后开始重构代码
	*	如何度量重构的结果：引入bad smell，通过重构消除bad smell
	*	引出问题，怎么识别bad smell
	*	测试绿，在重构，稳定之后进行大量重构
	*	分析现有的代码，识别bad smell
	*	引入interface是满足交换性
	*	keyboard/mouse模式，一个人使用键盘，另一个使用鼠标，练习重构
*	引入空值率的需求，task列表发生改变
	*	需求列表和设计是相关的，所以越熟悉就越容易写出task list来