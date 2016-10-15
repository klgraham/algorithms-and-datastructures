package org.klgraham.datastructures.list;

import java.util.Optional;

/**
 * Description of file content.
 *
 * @author kgraham
 *         10/4/16
 */
public class Node<T extends Comparable<T>>
{
	private T data;
	private Optional<Node<T>> next;
	private Optional<Node<T>> previous;

	public Node(T data) {
		this.data = data;
		this.next = Optional.empty();
		this.previous = Optional.empty();
	}

	public T getData() {
		return data;
	}

	public Optional<Node<T>> getNext() {
		return next;
	}

	public boolean hasNext() {
		return next.isPresent();
	}

	public boolean hasPrevious() {
		return previous.isPresent();
	}

	public void setData(final T data)
	{
		this.data = data;
	}

	public void setNext(final Node<T> next)
	{
		this.next = Optional.ofNullable(next);
	}

	public Optional<Node<T>> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = Optional.ofNullable(previous);
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Node<?> node = (Node<?>) o;

		return data != null ? data.equals(node.data) : node.data == null;

	}

	@Override
	public int hashCode()
	{
		return data != null ? data.hashCode() : 0;
	}
}
