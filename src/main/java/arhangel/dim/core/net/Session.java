package arhangel.dim.core.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;

import arhangel.dim.core.User;
import arhangel.dim.core.messages.Message;
import arhangel.dim.core.store.MessageStore;
import arhangel.dim.core.store.UserStore;
import arhangel.dim.server.Server;

/**
 * Здесь храним всю информацию, связанную с отдельным клиентом.
 * - объект User - описание пользователя
 * - сокеты на чтение/запись данных в канал пользователя
 */
public class Session implements ConnectionHandler {

    /**
     * Пользователь сессии, пока не прошел логин, user == null
     * После логина устанавливается реальный пользователь
     */
    private User user;

    // сокет на клиента
    private Socket socket;

    /**
     * С каждым сокетом связано 2 канала in/out
     */
    private InputStream in;
    private OutputStream out;

    private Connection connection;
    private UserStore userStorage;
    private MessageStore messageStorage;
    private Server server;
    private Protocol protocol;

    @Override
    public void send(Message msg) throws ProtocolException, IOException {
        // TODO: Отправить клиенту сообщение
    }

    @Override
    public void onMessage(Message msg) {
        // TODO: Пришло некое сообщение от клиента, его нужно обработать
    }

    @Override
    public void close() {
        // TODO: закрыть in/out каналы и сокет. Освободить другие ресурсы, если необходимо
    }

    public UserStore getUserStorage() {
        return  userStorage;
    }

    public MessageStore getMessageStorage() {
        return  messageStorage;
    }

    public void authUser(User user) {
        this.user = user;
    }
}
