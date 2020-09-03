package com.wake.nlkm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wake.nlkm.entity.Word;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.PrintWriter;

/**
 * @Author Ganty
 * @Date 2020/8/23
 * @Des
 */
public class WordHttpTest extends BaseTest {



    @Test
    public void testWordBatch() throws Exception{

        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/word/get/list")
                .param("page", "1")
                .param("limit", "10")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("utf-8");
        String responseString = response.getContentAsString();
        System.out.println(responseString);
        JSONObject jsonObject =  JSON.parseObject(responseString);
        Integer code = jsonObject.getInteger("code");
        JSONObject dataObj = jsonObject.getJSONObject("data");
        Assert.assertEquals(code,new Integer(0));
        Assert.assertNotNull(dataObj);
    }

    @Test
    public void testGetWordInfo() throws Exception{

        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/word/get/info")
                .param("word", "好")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("utf-8");
        String responseString = response.getContentAsString();
        System.out.println(responseString);
        JSONObject jsonObject =  JSON.parseObject(responseString);
        Integer code = jsonObject.getInteger("code");
        JSONObject dataObj = jsonObject.getJSONObject("data");
        Assert.assertEquals(code,new Integer(0));
        Assert.assertNotNull(dataObj);
    }

    @Test
    public void testUpdateWordInfo() throws Exception{

        String para_text = "{\"id\":36199,\"word\":\"好\",\"word_id\":\"ac2c8f13c6e60810197b19d683f5f184\",\"pinyin\":\"hǎo、hào\",\"redical\":\"女\",\"stroke_count\":\"6\",\"traditional\":\"好\",\"is_huiyizi\":1,\"is_xingshengzi\":0,\"is_rate_word\":0,\"level\":1,\"wubi\":\"VBG\",\"basic_mean\":\"[ hǎo ]\\n1.优点多的；使人满意的（跟“坏”相对）：～人。～东西。～事情。～脾气。庄稼长得很～。\\n2.合宜；妥当：初次见面，不知跟他说些什么～。\\n3.用在动词前，表示使人满意的性质在哪方面：～看。～听。～吃。\\n4.友爱；和睦：友～。～朋友。他跟我～。\\n5.（身体）健康；（疾病）痊愈：体质～。身子比去年～多了。他的病～了。\\n6.用于套语：～睡。您～走。\\n7.用在动词后，表示完成或达到完善的地步：计划订～了。功课准备～了。外边太冷，穿～了衣服再出去。坐～吧，要开会了。\\n8.表示赞许、同意或结束等语气：～， 就这么办。～了， 不要再说了。\\n9.反话，表示不满意：～， 这一下可麻烦了。\\n10.用在形容词前面问数量或程度，用法跟“多”相同：哈尔滨离北京～远?\\n[ hào ]\\n1.喜爱（跟“恶”wù相对）：嗜～。～学。～动脑筋。～吃懒做。他这个人～表现自己。\\n2.常容易（发生某种事情）：刚会骑车的人～摔跤。\\n\",\"detail_mean\":\"好 [hào]\\n〈动〉\\n1. 喜好;喜爱 \\n好憎者,心之暴也。——《淮南子·精神》\\n人之好我。——《诗·小雅·鹿鸣》\\n好治不病。——《韩非子·喻老》\\n敏而好学。——《论语》\\n黔无驴,有好事者船载以入。——唐· 柳宗元《三戒》\\n自幼好武术。——清· 徐珂《清稗类钞·战事类》\\n 又如:好表现;好善(喜爱行善);好涵高躅(喜欢混迹于高人之列);好戏子(好奇);好玩(爱玩儿)\\n2. 指常常容易发生 。\\n如:好晕船;好伤风;土豆子好烂\\n3. 另见 hǎo\\n好 [hǎo]\\n〈形〉\\n1. (会意。从女,从子。本义:美,貌美)\\n2. 指女子貌美 \\n好,美也。——《说文》\\n凡美色或谓之好。——《方言二》\\n不可谓好。——《国语·晋语》。注:“美也。”\\n是女子不好。——《史记·滑稽列传》\\n鬼侯有子而好。——《战国策·赵策》\\n秦氏有好女。——《乐府诗集·陌上桑》\\n 又如:好皮囊(好看的外貌);好鸟(美丽的鸟);好不丑(反语。即好不俊,俊得很);好美(美貌);好闲(容貌美丽,举止闲雅);好妇(美貌的妇女)\\n3. 善,优良,良好 \\n领恶而全好者与。——《礼记·仲尼燕居》。注:“善也。”\\n父信谗而不好。——《楚辞·惜诵》\\n又是江南好风景。——唐· 杜甫《江南逢李龟年》\\n好雨知时节。——唐· 杜甫《春夜喜雨》\\n江南好。——唐· 白居易《忆江南》\\n注曰不好。——宋· 洪迈《容斋续笔》\\n 又如:好天良夜(美好的时节);好日(吉日;好天;又指结婚佳期);好头脑(好对象;好人物);好言(善言;好话)\\n4. 交好;友爱 \\n妻子好合。——《诗·小雅·常棣》\\n欲与王为好。——《史记·廉颇蔺相如列传》\\n结好孙权。——《三国志·诸葛亮传》\\n情好日密。\\n游处相好。——宋· 王安石《答司马谏议书》\\n 又如:好会(诸侯间友好的会盟);好达达(妇女对男子的昵称)\\n5. 健康 。\\n如:他看起来很好;他的健康状况仍然是很好的;好身手(体格雄壮,身手矫健)\\n6. 容易 。\\n如:这个问题好回答;这事好办;好吃的果儿(容易对付的人)\\n7. 完成;完毕 \\n田车既好。——《诗·小雅·车攻》\\n凤生将书封好,一同玉蟾蜍交付 龙香。——《二刻拍案惊奇》\\n 又如:工具都准备好了\\n8. 表示赞许、同意或结果;是,同意 [all right;OK,okay]。\\n如:好,我十点钟不找你\\n9. 便于;宜于 \\n缁衣之好兮。——《诗·郑风·缁衣》\\n 又如:好合(志意相合)\\n〈副〉\\n1. 很,甚,太 ——表示程度,多含感叹语气。\\n如:好大的眼睛;好深的沟;好乔(十分古怪);好杀(极言其好);好是(真是,很是)\\n2. 用在数量词、时间词前面,表示多或久 。\\n如:等了好半天;来了好多人;过了好久;好歇(好一会儿);好几时(很长时间);好早晚(时候很晚)\\n3. 用在某些动词前面,表示效果好 。\\n如:好看;好听;好吃\\n〈助动〉\\n1. 可以 。\\n如:我好进来吗?\\n2. 应该 。\\n如:天快要下雨了,你好走了吧\\n3. 宜于;便于;以便 \\n青春作伴好还乡。——唐· 杜甫《闻官军收河南河北》\\n 又如:想法打蛇的头,好打晕它;你作个决定,我好回他;你交代下来,我好去叫他\\n4. 另见 hào\\n\",\"zuci\":\"正好、你好、只好、好玩、问好、好看、更好、好像、刚好、和好、最好、叫好、合好、美好\",\"source\":\"\",\"liju\":\"\",\"synonym\":\"佳、美\",\"antonym\":\"坏、孬、差、恶、次、歹、糟、赖\",\"miyu\":\"“好”为谜底的谜语\\n1.你站在女孩身边（打一字）\\n2.有儿有女日子美（打一字）\\n3.女排第一,男排第二（打一字）\\n4.巾帼（打一字）\\n5.外孙（打一汉字）\\n6.儿女成双（打一字）\\n7.危楼高百尺（打一字）\\n8.一肚生下龙凤胎（打一字）\\n\",\"baike\":\"好（good），汉字。多音字，读hǎo时作形容词泛指一切美好的事物，或同意、应允。读hào时作动词，表示喜欢的意思，乃是中国最常用的汉字之一。\",\"createtime\":\"2020-06-03T09:13:16.000+00:00\",\"updatetime\":\"2020-06-04T03:19:18.000+00:00\"}\n";
        Word word = JSONObject.parseObject(para_text,new TypeReference<Word>(){});
        System.out.println(word.getId());
        System.out.println(word.getZuci());
        String zuci = word.getZuci() + "、好运";
        word.setZuci(zuci);
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/word/update/info")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(word))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        response.setCharacterEncoding("utf-8");
        String responseString = response.getContentAsString();
        System.out.println(responseString);
        JSONObject jsonObject =  JSON.parseObject(responseString);
        Integer code = jsonObject.getInteger("code");
        Assert.assertEquals(code,new Integer(0));

//        校验

        response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/word/get/info")
                .param("word", "好")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("utf-8");
        responseString = response.getContentAsString();
        System.out.println(responseString);
        jsonObject =  JSON.parseObject(responseString);
        code = jsonObject.getInteger("code");
        JSONObject dataObj = jsonObject.getJSONObject("data");
        String zuci2 = dataObj.getString("zuci");
        Assert.assertEquals(code,new Integer(0));
        Assert.assertEquals(zuci, zuci2);
    }

    @Test
    public void testUpdateHuiyizi() throws Exception{

//        String para_text = "{\"id\":36199,\"word\":\"好\",\"word_id\":\"ac2c8f13c6e60810197b19d683f5f184\",\"pinyin\":\"hǎo、hào\",\"redical\":\"女\",\"stroke_count\":\"6\",\"traditional\":\"好\",\"is_huiyizi\":1,\"is_xingshengzi\":0,\"is_rate_word\":0,\"level\":1,\"wubi\":\"VBG\",\"basic_mean\":\"[ hǎo ]\\n1.优点多的；使人满意的（跟“坏”相对）：～人。～东西。～事情。～脾气。庄稼长得很～。\\n2.合宜；妥当：初次见面，不知跟他说些什么～。\\n3.用在动词前，表示使人满意的性质在哪方面：～看。～听。～吃。\\n4.友爱；和睦：友～。～朋友。他跟我～。\\n5.（身体）健康；（疾病）痊愈：体质～。身子比去年～多了。他的病～了。\\n6.用于套语：～睡。您～走。\\n7.用在动词后，表示完成或达到完善的地步：计划订～了。功课准备～了。外边太冷，穿～了衣服再出去。坐～吧，要开会了。\\n8.表示赞许、同意或结束等语气：～， 就这么办。～了， 不要再说了。\\n9.反话，表示不满意：～， 这一下可麻烦了。\\n10.用在形容词前面问数量或程度，用法跟“多”相同：哈尔滨离北京～远?\\n[ hào ]\\n1.喜爱（跟“恶”wù相对）：嗜～。～学。～动脑筋。～吃懒做。他这个人～表现自己。\\n2.常容易（发生某种事情）：刚会骑车的人～摔跤。\\n\",\"detail_mean\":\"好 [hào]\\n〈动〉\\n1. 喜好;喜爱 \\n好憎者,心之暴也。——《淮南子·精神》\\n人之好我。——《诗·小雅·鹿鸣》\\n好治不病。——《韩非子·喻老》\\n敏而好学。——《论语》\\n黔无驴,有好事者船载以入。——唐· 柳宗元《三戒》\\n自幼好武术。——清· 徐珂《清稗类钞·战事类》\\n 又如:好表现;好善(喜爱行善);好涵高躅(喜欢混迹于高人之列);好戏子(好奇);好玩(爱玩儿)\\n2. 指常常容易发生 。\\n如:好晕船;好伤风;土豆子好烂\\n3. 另见 hǎo\\n好 [hǎo]\\n〈形〉\\n1. (会意。从女,从子。本义:美,貌美)\\n2. 指女子貌美 \\n好,美也。——《说文》\\n凡美色或谓之好。——《方言二》\\n不可谓好。——《国语·晋语》。注:“美也。”\\n是女子不好。——《史记·滑稽列传》\\n鬼侯有子而好。——《战国策·赵策》\\n秦氏有好女。——《乐府诗集·陌上桑》\\n 又如:好皮囊(好看的外貌);好鸟(美丽的鸟);好不丑(反语。即好不俊,俊得很);好美(美貌);好闲(容貌美丽,举止闲雅);好妇(美貌的妇女)\\n3. 善,优良,良好 \\n领恶而全好者与。——《礼记·仲尼燕居》。注:“善也。”\\n父信谗而不好。——《楚辞·惜诵》\\n又是江南好风景。——唐· 杜甫《江南逢李龟年》\\n好雨知时节。——唐· 杜甫《春夜喜雨》\\n江南好。——唐· 白居易《忆江南》\\n注曰不好。——宋· 洪迈《容斋续笔》\\n 又如:好天良夜(美好的时节);好日(吉日;好天;又指结婚佳期);好头脑(好对象;好人物);好言(善言;好话)\\n4. 交好;友爱 \\n妻子好合。——《诗·小雅·常棣》\\n欲与王为好。——《史记·廉颇蔺相如列传》\\n结好孙权。——《三国志·诸葛亮传》\\n情好日密。\\n游处相好。——宋· 王安石《答司马谏议书》\\n 又如:好会(诸侯间友好的会盟);好达达(妇女对男子的昵称)\\n5. 健康 。\\n如:他看起来很好;他的健康状况仍然是很好的;好身手(体格雄壮,身手矫健)\\n6. 容易 。\\n如:这个问题好回答;这事好办;好吃的果儿(容易对付的人)\\n7. 完成;完毕 \\n田车既好。——《诗·小雅·车攻》\\n凤生将书封好,一同玉蟾蜍交付 龙香。——《二刻拍案惊奇》\\n 又如:工具都准备好了\\n8. 表示赞许、同意或结果;是,同意 [all right;OK,okay]。\\n如:好,我十点钟不找你\\n9. 便于;宜于 \\n缁衣之好兮。——《诗·郑风·缁衣》\\n 又如:好合(志意相合)\\n〈副〉\\n1. 很,甚,太 ——表示程度,多含感叹语气。\\n如:好大的眼睛;好深的沟;好乔(十分古怪);好杀(极言其好);好是(真是,很是)\\n2. 用在数量词、时间词前面,表示多或久 。\\n如:等了好半天;来了好多人;过了好久;好歇(好一会儿);好几时(很长时间);好早晚(时候很晚)\\n3. 用在某些动词前面,表示效果好 。\\n如:好看;好听;好吃\\n〈助动〉\\n1. 可以 。\\n如:我好进来吗?\\n2. 应该 。\\n如:天快要下雨了,你好走了吧\\n3. 宜于;便于;以便 \\n青春作伴好还乡。——唐· 杜甫《闻官军收河南河北》\\n 又如:想法打蛇的头,好打晕它;你作个决定,我好回他;你交代下来,我好去叫他\\n4. 另见 hào\\n\",\"zuci\":\"正好、你好、只好、好玩、问好、好看、更好、好像、刚好、和好、最好、叫好、合好、美好\",\"source\":\"\",\"liju\":\"\",\"synonym\":\"佳、美\",\"antonym\":\"坏、孬、差、恶、次、歹、糟、赖\",\"miyu\":\"“好”为谜底的谜语\\n1.你站在女孩身边（打一字）\\n2.有儿有女日子美（打一字）\\n3.女排第一,男排第二（打一字）\\n4.巾帼（打一字）\\n5.外孙（打一汉字）\\n6.儿女成双（打一字）\\n7.危楼高百尺（打一字）\\n8.一肚生下龙凤胎（打一字）\\n\",\"baike\":\"好（good），汉字。多音字，读hǎo时作形容词泛指一切美好的事物，或同意、应允。读hào时作动词，表示喜欢的意思，乃是中国最常用的汉字之一。\",\"createtime\":\"2020-06-03T09:13:16.000+00:00\",\"updatetime\":\"2020-06-04T03:19:18.000+00:00\"}\n";
//        Word word = JSONObject.parseObject(para_text,new TypeReference<Word>(){});
//        System.out.println(word.getId());
//        System.out.println(word.getZuci());
        JSONObject param_json = new JSONObject();
        param_json.put("word", "好");
        param_json.put("state", true);
        System.out.println(param_json.toJSONString());
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/word/update/huiyizi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(param_json.toJSONString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        response.setCharacterEncoding("utf-8");
        String responseString = response.getContentAsString();
        System.out.println(responseString);
        JSONObject resp_json =  JSON.parseObject(responseString);
        Integer code = resp_json.getInteger("code");
        Assert.assertEquals(code,new Integer(0));

//        校验

        response = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/word/get/info")
                .param("word", "好")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("utf-8");
        responseString = response.getContentAsString();
        System.out.println(responseString);
        JSONObject jsonObject1 =  JSON.parseObject(responseString);
        code = jsonObject1.getInteger("code");
        JSONObject dataObj = jsonObject1.getJSONObject("data");
        Integer huiyizi_flag = dataObj.getInteger("is_huiyizi");
        Boolean is_huiyizi = huiyizi_flag == 0 ? false:true;
        Assert.assertEquals(code,new Integer(0));
        Assert.assertEquals(is_huiyizi, param_json.getBoolean("state"));
    }


}
