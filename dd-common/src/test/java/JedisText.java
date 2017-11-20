/**
 * User: Administrator
 * Date: 2017/11/20
 * Time: 17:10
 * Version:V1.0
 */
public class JedisText {
    /*@Test
    public void testJedis1(){
        Jedis jedis = new Jedis("101.132.178.188",6379);
        jedis.set("name","lys");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

    @Test
    public void testJedis2(){
        //获取jedis池
        JedisPool jedisPool = new JedisPool("101.132.178.188",6379);
        //获取Jedis对象
        Jedis jedis = jedisPool.getResource();
        jedis.set("name","lys1");
        System.out.println(jedis.get("name"));
        //关闭连接
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testJedis3(){
        //创建集群节点集合
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        //将6个节点加入到集合中
        nodes.add(new HostAndPort("101.132.178.188",9001));
        nodes.add(new HostAndPort("101.132.178.188",9002));
        nodes.add(new HostAndPort("101.132.178.188",9003));
        nodes.add(new HostAndPort("101.132.178.188",9004));
        nodes.add(new HostAndPort("101.132.178.188",9005));
        nodes.add(new HostAndPort("101.132.178.188",9006));
        //创建集群对象
        JedisCluster jedisCluster = new JedisCluster(nodes);
        //存入数据
        jedisCluster.set("name2","lys2");
        jedisCluster.hset("name3","123456","{'name3':'dhc'}");
        System.out.println(jedisCluster.get("name2"));
        //关闭连接
        jedisCluster.close();
    }*/
}
