package hello.advanced.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class TraceId {

	private String id;
	private int level;

	public TraceId() {
		this.id = createId();
		this.level = 0;
	}

	private TraceId(String id, int level) {
		this.id = id;
		this.level = level;
	}

	private String createId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public TraceId createNextId() {
		return new TraceId(id, level + 1);
	}

	public TraceId createPrevId() {
		return new TraceId(id, level - 1);
	}
}
