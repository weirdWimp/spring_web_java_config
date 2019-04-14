// import com.candy.controller.HomeController;
// import com.candy.controller.MessageController;
// import com.candy.entity.MessageEntity;
// import com.candy.repository.EntityRepository;
// import org.junit.Test;
// import org.mockito.Mockito;
// import org.springframework.mock.web.portlet.MockClientDataRequest;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.servlet.view.InternalResourceView;
//
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
//
// public class ControllerTest {
//     @Test
//     public void testController() throws Exception {
//         HomeController controller = new HomeController();
//         MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//         mockMvc.perform(MockMvcRequestBuilders.get("/homepage"))
//                 .andExpect(MockMvcResultMatchers.view().name("home"));
//     }
//
//     @Test
//     public void testMessageController () throws  Exception {
//         List<MessageEntity> messageEntities = createMsgEntities();
//         EntityRepository repository = Mockito.mock(EntityRepository.class);
//         Mockito.when(repository.getMessageList(10)).thenReturn(messageEntities);
//         MessageController controller = new MessageController(repository);
//
//         MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
//                 .setSingleView(new InternalResourceView("/WEB-INF/views/message.jsp")).build();
//
//         /**
//          * 测试该控制器对/messageList的GET请求处理是否返回'message'的视图名；
//          * 模型中是否包含'messageList'的属性，以及该属性对应的值是否是最初设置的 messageEntities
//          *
//          */
//         mockMvc.perform(MockMvcRequestBuilders.get("/messageList"))
//                 .andExpect(MockMvcResultMatchers.view().name("message"))
//                 .andExpect(MockMvcResultMatchers.model().attributeExists("messageList"))
//                 .andExpect(MockMvcResultMatchers.model().attribute("messageList", messageEntities));
//     }
//
//     @Test
//     public void testPathVariableMessageController () throws  Exception {
//         List<MessageEntity> messageEntities = createMsgEntities();
//         EntityRepository repository = Mockito.mock(EntityRepository.class);
//         Mockito.when(repository.getMessageListByName("Tom")).thenReturn(messageEntities);
//         MessageController controller = new MessageController(repository);
//
//         MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
//                 .setSingleView(new InternalResourceView("/WEB-INF/views/message.jsp")).build();
//
//         mockMvc.perform(MockMvcRequestBuilders.get("/messageList/Tom"))
//                 .andExpect(MockMvcResultMatchers.view().name("messageListByName"))
//                 .andExpect(MockMvcResultMatchers.model().attributeExists("messageList"))
//                 .andExpect(MockMvcResultMatchers.model().attribute("messageList", messageEntities));
//     }
//
//     private List<MessageEntity> createMsgEntities () {
//         List<MessageEntity> list = new ArrayList<>(20);
//         for (int i = 0; i <= 20; i++) {
//             list.add(new MessageEntity("Tom", LocalDateTime.now(), "Message:" + i));
//         }
//         return list;
//     }
// }
