import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Task } from 'src/app/shared/model/task.model';
import { TaskService } from 'src/app/shared/service/task.service';

@Component({
  selector: 'tasklist',
  templateUrl: './tasklist.component.html',
  styleUrls: ['./tasklist.component.css']
})
export class TasklistComponent implements OnInit {

  public tasks: Task[];

  public form: FormGroup;

  public editingTask: Task;

  public editingForm: FormGroup;

  public isEditing: boolean;

  constructor(
    private formBuilder: FormBuilder,
    public taskService: TaskService
  ) { }

  ngOnInit(): void {
    this.getTasks();

    this.form = this.formBuilder.group({
      description: ['', [Validators.required]],
      state: [0]
    });

    this.editingForm = this.formBuilder.group({
      description: ['', [Validators.required]],
      state: [0]
    })

    this.isEditing = false;
  }

  getTasks() {
    this.taskService.getTasks().subscribe(data => {
      this.tasks = data;
    });
  }

  createTask() {
    if (!this.verifyBlankInput(this.form.controls['description'].value)) {
      this.taskService.createTask(this.form.value).subscribe(result => {
      })
      window.location.reload();
    }
  }

  deleteTask(id: number) {
    this.taskService.deleteTask(id).subscribe(result => {
    });
    window.location.reload();
  }

  updateDescription(task: Task) {
    if (!this.verifyBlankInput(this.editingForm.controls['description'].value)) {
      this.taskService.updateDescription(task).subscribe(result => {
      });
      this.isEditing = false;
    } 
  }

  updateState(task: Task) {
    this.taskService.updateState(task).subscribe(result => {
    });
  }

  deleteAll(tasks: Task[]) {
    tasks.map((task) => {
      this.taskService.deleteTask(task.id).subscribe(result => {
      });
    })
    window.location.reload();
  }

  editTask(task: Task) {
    this.editingTask = task;
    this.isEditing = true;
  }

  verifyState(state: string) {
    if (state == "OPEN") {
      return false;
    }
    return true;
  }

  verifyBlankInput(input: string) {
    if (input.length == 0) {
      return true;
    }
    return false;
  }
}
