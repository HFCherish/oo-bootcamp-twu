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

### tasks
1. 停车
	1. 该 parking boy 管理的停车场，有空位，可以停车
	2. 该 parking boy 管理的停车场，都有空位，往以第一个有空位的停车场停车
	3. 该 parking boy 管理的停车场，都没有空位，不能停车
2. 取车
	3. 车停在当前 parking boy 管理的某个停车场，可以取车
	4. 车不停在当前 parking boy 管理的停车场，不可以取车
### tasks
1. 停车
	2. 该 parking boy 管理的停车场，空位数不同时，往空位多的停车场停车
	3. 该 parking boy 管理的停车场，空位数相同时，可以停车成功
	4. 该 parking boy 管理的停车场，没有空位时，停车失败

### 需要开始抽接口吗？因为有相同的方法签名，是否是 bad smell？

	2. 该 parking boy 管理的停车场，空车率不同时，往空位多的停车场停车


*	引入ParkingLot，可以停车取车 （20分钟，tasking coding）