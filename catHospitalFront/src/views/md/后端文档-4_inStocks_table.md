#### inStocks_table
inStocks_table 接口设计如下：

1. 获得所有的库存数据
    请求路径：
    请求参数：
    请求类型：
    响应结果：
    控制层语句：
```java
    @GetMapping("")
    public List<InStocksVO> getAll(){
        return inStocksService.getAll();
    }
```
    服务层实现语句：
```java
    public List<InStocksVO> getAll() {
        List<InStocksVO> inStocksVOList = new ArrayList<>();
        for(InStocks inStocks:inStocksMapper.selectInStocksAll()){
            inStocksVOList.add(doToVo(inStocks));
        }
        return inStocksVOList;
    }
```
    SQL语句：
```xml
    <select id="selectInStocksAll" resultType="com.renkaen.cat_hospital.bean.PO.InStocks">
        select *
        from inStocks_table;
    </select>
```
2. 获得所有的消耗品的库存数据及入库数据
    请求路径：
    请求参数：
    请求类型：
    响应结果：
    控制层语句：
    ```java
    @GetMapping("/type/{type}")
    public List<InStocksJoinInboundVO> getAllinStockJoinInbound(@PathVariable("type")int type){
        return inStocksService.getAllInStocksJoinInbound(type);
    }
    ```
    服务层实现语句：
```java
    public List<InStocksJoinInboundVO> getAllInStocksJoinInbound(int type) {
        List<InStocksJoinInboundVO> inStocksJoinInboundVOList = new ArrayList<>();
        for (InStocksJoinInboundDTO inStocksJoinInboundDTO:inStocksMapper.selectInStocksJoinInboundByType(type)){
            InStocksJoinInboundVO inStocksJoinInboundVO = new InStocksJoinInboundVO();
            BeanUtils.copyProperties(inStocksJoinInboundDTO,inStocksJoinInboundVO);
            inStocksJoinInboundVO.setKey(inStocksJoinInboundDTO.getKeyTime());
            inStocksJoinInboundVO.setName(inStocksJoinInboundDTO.getNamae());
            List<InboundVO> inboundVOList = new ArrayList<>();
            for(Inbound inbound:inStocksJoinInboundDTO.getInbound()){
                inboundVOList.add(new InboundVO(inbound));
            }
            inStocksJoinInboundVO.setInbound(inboundVOList);
            inStocksJoinInboundVOList.add(inStocksJoinInboundVO);
        }
        return inStocksJoinInboundVOList;
    }
```
    SQL语句：
```xml
    <!--1对多联表查inStocks和inbound-->
    <resultMap id="InStocksJoinInbound" type="com.renkaen.cat_hospital.bean.DTO.InStocksJoinInboundDTO" autoMapping="true">
        <result property="id" column="id"/>
        <collection property="inbound" column="id" select="joinInbound" />
    </resultMap>
    <select id="selectInStocksJoinInboundByType" resultMap="InStocksJoinInbound">
        select *
        from inStocks_table
        where type = #{type}
    </select>
    <select id="joinInbound" resultType="com.renkaen.cat_hospital.bean.PO.Inbound">
        select *
        from inbound_table
        where inStockId = #{id}
    </select>
```
    数据类型转换：
    DTO/PO to VO
```java
private InStocksVO doToVo(InStocks inStocks){
        InStocksVO inStocksVO = new InStocksVO();
        BeanUtils.copyProperties(inStocks,inStocksVO);
        inStocksVO.setKey(inStocks.getKeyTime());
        inStocksVO.setName(inStocks.getNamae());
        return inStocksVO;
    }
```