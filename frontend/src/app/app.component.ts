import { state } from '@angular/animations';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Task } from './shared/model/task.model';
import { TaskService } from './shared/service/task.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  public tasks: Task[];

  public form: FormGroup;

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
  }

  getTasks() {
    this.taskService.getTasks().subscribe(data => {
      this.tasks = data;
    });
  }

  createTask() {
    this.taskService.createTask(this.form.value).subscribe(result => {
    })
    this.form.reset();
    window.location.reload();
  }

  deleteTask(id: number) {
    this.taskService.deleteTask(id).subscribe(result => {
    });
    window.location.reload();
  }

  updateTask(task: Task) {
    this.taskService.updateTask(task).subscribe(result => {
    });
  }

  deleteAll(tasks: Task[]) {
    console.log(tasks);
    
    tasks.map((task) => {
      this.taskService.deleteTask(task.id).subscribe(result => {
      });
    })
    window.location.reload();
  }
  
  verifyState(state: string) {
    if (state == "OPEN") {
      return false;
    }
    return true;
  }
}
