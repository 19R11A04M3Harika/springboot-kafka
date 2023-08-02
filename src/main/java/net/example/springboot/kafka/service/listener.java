import net.example.springboot.kafka.model.student;
import net.example.springboot.kafka.repository.myrepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class listener {
    private myrepository repo;

    private static final Logger LOGGER = LoggerFactory.getLogger(listener.class);

    @KafkaListener(topics="demo_topic", groupId = "kafka")
    public void recieve(student s){
        repo.save(s);
    }


}
