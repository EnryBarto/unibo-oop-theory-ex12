package p12.exercise;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class MultiQueueImpl<T, Q> implements MultiQueue<T, Q>{
    private final Map<Q, Queue<T>> queues;

    public MultiQueueImpl() {
        this.queues = new HashMap<Q, Queue<T>>();
    }

    @Override
    public Set<Q> availableQueues() {
        return this.queues.keySet();
    }

    @Override
    public void openNewQueue(Q queue) {
        // Check if the argument is valid
        if (queue == null) {
            throw new NullPointerException();
        }
        if (this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("This queue already exists");
        }

        // Creates the entry in the Map and the associated List
        this.queues.put(queue, new LinkedList<T>());
    }

    @Override
    public boolean isQueueEmpty(Q queue) {
        // Check if the argument is valid
        if (queue == null) {
            throw new NullPointerException();
        }
        if (!this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("The queue requested doesn't exist");
        }

        return this.queues.get(queue).isEmpty();
    }

    @Override
    public void enqueue(T elem, Q queue) {
        // Check if the arguments are valid
        if (queue == null || elem == null) {
            throw new NullPointerException();
        }
        if (!this.queues.containsKey(queue)) {
            throw new IllegalArgumentException("The queue requested doesn't exixsts");
        }

        this.queues.get(queue).add(elem);
    }

    @Override
    public T dequeue(Q queue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public Map<Q, T> dequeueOneFromAllQueues() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeueOneFromAllQueues'");
    }

    @Override
    public Set<T> allEnqueuedElements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allEnqueuedElements'");
    }

    @Override
    public List<T> dequeueAllFromQueue(Q queue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeueAllFromQueue'");
    }

    @Override
    public void closeQueueAndReallocate(Q queue) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeQueueAndReallocate'");
    }

}
