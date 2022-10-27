/*
 * package com.academy.mapper;
 * 
 * import java.util.stream.IntStream;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.academy.domain.ReplyVO; import com.academy.domain.Criteria;
 * 
 * import lombok.Setter; import lombok.extern.log4j.Log4j;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @ContextConfiguration(classes = { com.academy.config.RootConfig.class})
 * 
 * @Log4j public class ReplyMapperTests {
 * 
 * // 테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인할 것 private Long[] bnoArr = { 16899L,
 * 16898L, 16897L, 16896L, 16895L };
 * 
 * @Setter(onMethod_ = @Autowired) private ReplyMapper mapper;
 * 
 * //생성
 * 
 * @Test public void testCreate() { IntStream.rangeClosed(1, 10).forEach(i -> {
 * // 1~10반복 ReplyVO vo = new ReplyVO();
 * 
 * vo.setBno(bnoArr[i % 5]); vo.setReply("댓글 테스트 " + i); vo.setReplyer("replyer"
 * + i);
 * 
 * mapper.insert(vo);
 * 
 * log.info(vo); });
 * 
 * }
 * 
 * // 조회
 * 
 * @Test public void testRead() { Long targetRno = 5L;
 * 
 * ReplyVO vo = mapper.read(targetRno);
 * 
 * log.info(vo); }
 * 
 * //삭제
 * 
 * @Test public void testDelete() { Long targetRno = 1L;
 * 
 * mapper.delete(targetRno); } //수정
 * 
 * @Test public void testUpdate() { Long targetRno = 10L;
 * 
 * ReplyVO vo = mapper.read(targetRno);
 * 
 * vo.setReply("Update Reply");
 * 
 * int count = mapper.update(vo);
 * 
 * log.info("UPDATE COUNT : " + count); }
 * 
 * //연동 확인 완료 //@Test public void testMapper() {
 * 
 * log.info(mapper); }
 * 
 * }
 * 
 */