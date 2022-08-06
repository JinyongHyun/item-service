package hello.itemservice.web.basic;

import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor //final이 붙은것 생성자 자동 생성
public class BasicItemController {

    private final ItemRepository itemRepository;


    }

