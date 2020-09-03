package com.wake.nlkm;

import com.wake.nlkm.controller.WordController;
import com.wake.nlkm.entity.Word;
import com.wake.nlkm.service.WordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Ganty
 * @Date 2020/8/19
 * @Des
 */

@SpringBootTest(classes = NlkmApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class WordTest {

    @Autowired
    private WordService wordService;

    @Autowired
    private WordController wordController;

    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }

    @Test
    public void WordTest1() throws Exception{
        Word word = wordService.queryWordInfo("好");
//        System.out.println(word.getWord());
        System.out.println(word.getZuci());
        Assert.assertEquals(word.getWord(), "好");
    }

    @Test
    public void TestAddWord() {
        try {
            Word word = new Word();
            word.setWord("好");
            int flag = wordService.addWordInfo(word);
            Assert.assertEquals(flag, 0);
        } catch (Exception e){

        }

    }

    @Test
    public void TestUpdateWordInfo() {
        try {
            Word word = wordService.queryWordInfo("好");
            String zuci = word.getZuci();
            zuci = zuci + "、多好";
            word.setZuci(zuci);
            int flag = wordService.updateWordInfo(word);
            Assert.assertEquals(flag, 1);
            Word word2 = wordService.queryWordInfo("好");
            Assert.assertEquals(word2.getZuci(), zuci);
        } catch (Exception e){

        }

    }

    @Test
    public void TestUpdateHuiyiziState() {
//        锕
        try {
            String wordName = "锕";
            int wordId = 32208;
            Integer state = 1;
            int flag = wordService.updateHuiyiziState(wordId, state);
            Assert.assertEquals(flag, 1);
            Word word = wordService.queryWordInfo(wordName);
            Assert.assertEquals(word.getIs_huiyizi(),new Integer(1));
        } catch (Exception e){

        }

    }

    @Test
    public void TestUpdateXingshengziState() {
        try {
            String wordName = "锕";
            int wordId = 32208;
            Integer state = 1;
            int flag = wordService.updateXingshengziState(wordId, state);
            Assert.assertEquals(flag, 1);
            Word word = wordService.queryWordInfo(wordName);
            Assert.assertEquals(word.getIs_xingshengzi(),new Integer(1));
        } catch (Exception e) {

        }

    }

    @Test
    public void TestUpdateRateWord() {

        try {
            String wordName = "锕";
            int wordId = 32208;
            Integer state = 1;
            int flag = wordService.updateRateWordState(wordId, state);
            Assert.assertEquals(flag, 1);
            Word word = wordService.queryWordInfo(wordName);
            Assert.assertEquals(word.getIs_rate_word(),new Integer(1));
        } catch (Exception e){

        }

    }

    @Test
    public void TestUpdateWordLevel() {
        try {
            String wordName = "锕";
            Integer level = 2;
            int wordId = 32208;
            int flag = wordService.updateWordLevel(wordId, level);
            Assert.assertEquals(flag, 1);
            Word word = wordService.queryWordInfo(wordName);
            Assert.assertEquals(word.getLevel(),new Integer(2));
        } catch (Exception e){

        }

    }

    public static void main(String[] args) {
//        super.
    }

}
