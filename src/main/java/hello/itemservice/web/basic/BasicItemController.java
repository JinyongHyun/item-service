package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor //final이 붙은것 생성자 자동 생성
public class BasicItemController {

    private final ItemRepository itemRepository;


    @GetMapping
    public String items(Model model){
       List<Item> items= itemRepository.findAll();
       model.addAttribute("items",items);
       return "basic/items";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }
    //상품등록
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }


//    @PostMapping("/add")
//    public String save(@RequestParam String itemName,
//                       @RequestParam int price,
//                       @RequestParam Integer quantity,
//                       Model model
//                       ){
//                Item item = new Item();
//                item.setItemName(itemName);
//                item.setPrice(price);
//                item.setQuantity(quantity);
//
//                itemRepository.save(item);
//                   //아이템 넣기
//                model.addAttribute("item", item);
//            //상품저장 후 상세화면에서 보여주기
//            //값들을 넘겨주기
//        return "basic/item";
//    }


      //모델 사용
      @PostMapping("/add")
      public String addItem(@ModelAttribute("item") Item item, Model model){

          itemRepository.save(item);
          //아이템 넣기
          model.addAttribute("item", item);
          //상품저장 후 상세화면에서 보여주기
          //값들을 넘겨주기
          return "basic/item";
      }


      //상품수정
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){ //어떤 상품을 수정할지 id로 확인
        Item item =itemRepository.findById(itemId); //findbyid로 id찾아서 담는다
        model.addAttribute("item",item);
        return "basic/editForm";
    }

/**
 *  테스트용 데이터
 */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA" ,1000,100));
        itemRepository.save(new Item("itemB" ,2000,200));
    }
    }

