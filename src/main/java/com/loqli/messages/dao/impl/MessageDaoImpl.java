package com.loqli.messages.dao.impl;

import com.loqli.messages.dao.MessageDao;
import com.loqli.messages.model.Message;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    Logger logger = Logger.getLogger(MessageDaoImpl.class);

    @PersistenceContext(unitName = "defaultPU")
    private EntityManager em;

    public MessageDaoImpl() {
        // needed for deserialization
    }

    @Override
    public List<Message> getMessages() {

        TypedQuery<Message> query = em.createQuery(
                "select a from " + Message.class.getSimpleName()
                        + " a order by a.id",
                Message.class);

        return query.getResultList();
    }

    @Override
    public int create(Message message) {

        em.persist(message);
        return 0;
    }

    @Override
    public Message getMessageById(int id) {
        return em.find(Message.class, id);
    }

    @Override
    public int deleteMessages(List<Message> messages) {

        try {
            for (Message l : messages) {
                deleteMessage(l.getId());
            }
        } catch (Exception e) {
            logger.error(e);
            return -1;
        }

        return 0;

    }

    @Override
    public int deleteMessage(int id) {

        int result = -1;

        try {
            Message message = em.find(Message.class, id);
            if(message !=null){
                em.remove(message);
                result = 0;
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return result;
    }
}
