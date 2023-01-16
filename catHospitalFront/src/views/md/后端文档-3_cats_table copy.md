#### Cats_table
Cats_table 接口设计如下：
1. 根据电话号码获得对应的宠物猫数据（可能有多只）
    请求路径：
    请求参数：
    请求类型：
    响应结果：
    控制层语句：
    ```java
    @GetMapping("/phone/{phoneNumber}")
    public List<CatsVO> getCatsByPhone(@PathVariable("phoneNumber")String phoneNumber){
        return catsService.getByPhone(phoneNumber);
    }
    ```
    服务层实现语句：
    ```java
    public  List<CatsVO> getByPhone(String phoneNumber) {
        List<CatsVO> catsVOList = new ArrayList<>();
        for(Cats cats:catsMapper.selectCatByPhone(phoneNumber)){
            catsVOList.add(new CatsVO(cats));
        }
        return catsVOList;
    }
    ```
    SQL语句：
    ```xml
    <select id="selectCatByPhone" resultType="com.renkaen.cat_hospital.bean.PO.Cats">
        select *
        from cats_table
        where phoneNumber = #{phoneNumber}
    </select>
    ```

2. 根据电话号码和宠物昵称获得对应的宠物数据
    请求路径：
    请求参数：
    请求类型：
    响应结果：
    控制层语句：
    ```java
    @GetMapping("/phonename/{phoneNumber}/{nickname}")
    public List<CatsVO> getCatsByPhoneAndName(@PathVariable("phoneNumber")String phoneNumber,@PathVariable("nickname")String nickname){
        return catsService.getByPhoneAndName(phoneNumber,nickname);
    }
    ```
    服务层实现语句：
    ```java
    public  List<CatsVO> getByPhoneAndName(String phoneNumber,String nickname) {
        List<CatsVO> catsVOList = new ArrayList<>();
        for(Cats cats:catsMapper.selectCatByPhoneNick(phoneNumber,nickname)){
            catsVOList.add(new CatsVO(cats));
        }
        return catsVOList;
    }
    ```
    SQL语句：
    ```xml
    <select id="selectCatByPhoneNick" resultType="com.renkaen.cat_hospital.bean.PO.Cats">
        select *
        from cats_table
        where phoneNumber = #{phoneNumber} and nickname = #{nickname}
    </select>
    ```

3. 获得所有的宠物数据
    请求路径：
    请求参数：
    请求类型：
    响应结果：
    控制层语句：
    ```java
    @GetMapping("")
    public List<CatsVO> getAllCats(){
        return catsService.getAllCats();
    }
    ```
    服务层实现语句：
    ```java
    public List<CatsVO> getAllCats() {
        List<Cats> catsList = catsMapper.selectAllCats();
        List<CatsVO> catsVOList = new ArrayList<>();
        for(Cats cats: catsList){
            catsVOList.add(new CatsVO(cats));
        }
        return catsVOList;
    }
    ```
    SQL语句：
    ```xml
    <select id="selectAllCats" resultType="com.renkaen.cat_hospital.bean.PO.Cats">
        select *
        from cats_table
    </select>
    ```

##### 数据类型转换：
    DTO/PO to VO
    通过构造函数实现
```java
    public CatsVO(Cats cats){
        id = cats.getId();
        nickname=cats.getNickname();
        catOwner=cats.getCatOwner();
        phoneNumber=cats.getPhoneNumber();
        birthday=cats.getBirthday();
        key=cats.getKeyTime();
        vaccine=JSONArray.fromObject(cats.getVaccine());
        vermifuge=JSONArray.fromObject(cats.getVermifuge());
        sex=cats.getSex();
        sterilize=cats.getSterilize();
    }
```
