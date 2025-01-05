package test;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TopicManagerSingleton {

    public static class TopicManager {

        Map<String, Topic> topics;
        private static final TopicManager instance = new TopicManager(); // וחייב לאתחל הוא לא חשוף החוצה

        private TopicManager() { // בנאי פרטי
        topics = new HashMap<>();
        }

        public synchronized Topic getTopic(String topicName) {
            if(!topics.containsKey(topicName)) {
                topics.put(topicName, new Topic(topicName));
            }
            return topics.get(topicName);
        }

        public Collection<Topic> getTopic() {
            return topics.values();
        }

        public void clear() {
            topics.clear();
        }
    }

    public static TopicManager get() {
        return TopicManager.instance;
    }
}
